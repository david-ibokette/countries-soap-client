package net.ibokette.continents

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ContinentsController(val continentsService: ContinentsService) {

    @GetMapping("/")
    fun helloWorld() : Any  {
        val country = continentsService.doSoapStuff()
        return object {
            val message = "Hello there earth - we in the $country"
        }
    }

    @GetMapping("/codes/{code}")
    fun helloFromCountry(@PathVariable code: String) : Any  {
        val country = continentsService.getCountryForCode(code)
        return object {
            val message = "Hello there earth - from $country"
        }
    }
}