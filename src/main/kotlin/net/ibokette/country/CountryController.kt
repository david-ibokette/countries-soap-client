package net.ibokette.country

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CountryController(val countryService: CountryService) {

    @GetMapping("/")
    fun helloWorld() : Any  {
        val country = countryService.doSoapStuff()
        return object {
            val message = "Hello there earth - we in the $country"
        }
    }

    @GetMapping("/codes/{code}")
    fun helloFromCountry(@PathVariable code: String) : Any  {
        val country = countryService.getCountryForCode(code)
        return object {
            val message = "Hello there earth - from $country"
        }
    }
}