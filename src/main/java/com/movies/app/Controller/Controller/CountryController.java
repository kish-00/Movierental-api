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
    @PostMapping("/addCountry")
    public Country handleAddCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    //gets all countries
    @GetMapping("/countries")
    public List<Country> handleGetAllCountries(){
        return countryService.getAllCountries();
    }

    //gets a country by its id
    @GetMapping("/country/{id}")
    public Country handleGetCountryById(@PathVariable int id){
        return countryService.getCountryById(id);
    }

    //get country by name
    @GetMapping("/country/{name}")
    public Country handleGetCountryByName(@PathVariable String name){
        return countryService.getCountryByName(name);
    }
    //update country
    @PutMapping("/updateCountry/{id}")
    public Country handleUpdateCountry(int id, Country countryInfo){
        return countryService.updateCountry(id, countryInfo);
    }

    // delete country
    @DeleteMapping("/deleteCountry/{id}")
    public String handleDeleteCountry(@PathVariable int id){
        return countryService.deleteCountry(id);
    }
}
