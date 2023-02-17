package net.ibokette.country

import net.ibokette.wsdl.CountryName
import net.ibokette.wsdl.CountryNameResponse
import org.slf4j.LoggerFactory
import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.client.core.SoapActionCallback

// Note: this is injected via the CountryConfiguration class
class CountryClient : WebServiceGatewaySupport() {
    fun getCountry(countryCode: String): CountryNameResponse {
        val request = CountryName()
        request.sCountryISOCode = countryCode
        log.info("Requesting location for $countryCode")
        return webServiceTemplate
            .marshalSendAndReceive(
                "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso", request,
                SoapActionCallback(
                    "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"
                )
            ) as CountryNameResponse
    }

    companion object {
        private val log = LoggerFactory.getLogger(CountryClient::class.java)
    }
}