package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Country;
import com.movies.app.Controller.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    //adds a country
    @PostMapping(value = "/addCountry", consumes = "application/JSON")
    public Country handleAddCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

//add multiple countries

    //gets all countries
    @GetMapping(value = "/countries", produces = "application/JSON")
    public List<Country> handleGetAllCountries(){
        return countryService.getAllCountries();
    }

    //gets a country by its id
    @GetMapping(value = "/country/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Country handleGetCountryById(@PathVariable int id){
        return countryService.getCountryById(id);
    }

    //update country
    @PutMapping(value = "/updateCountry/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Country handleUpdateCountry(int id, Country countryInfo){
        return countryService.updateCountry(id, countryInfo);
    }

    // delete country
    @DeleteMapping(value = "/deleteCountry/{id}")
    public String handleDeleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);
    }
}
