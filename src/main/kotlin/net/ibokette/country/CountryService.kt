package net.ibokette.country

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CountryService(val countryClient: CountryClient) {

    fun doSoapStuff(): String {
        return getCountryForCode("US")
    }

    fun getCountryForCode(code: String): String {
        logger.info("Input code is $code")
        return countryClient.getCountry(code).countryNameResult.also{
            logger.info("Result is $it")
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CountryClient::class.java)
    }
}