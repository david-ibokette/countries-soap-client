package net.ibokette.continents

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ContinentsService(val countryClient: CountryClient) {

    fun doSoapStuff(): String {
        val countryNameResponse = countryClient.getCountry("US")
        logger.info("Result is ${countryNameResponse.countryNameResult}")
        return countryNameResponse.countryNameResult
    }

    fun getCountryForCode(code: String): String {
        logger.info("Input code is $code")
        val countryNameResponse = countryClient.getCountry(code)
        logger.info("Result is ${countryNameResponse.countryNameResult}")
        return countryNameResponse.countryNameResult
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CountryClient::class.java)
    }
}