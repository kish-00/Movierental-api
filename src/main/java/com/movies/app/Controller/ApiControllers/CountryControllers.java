package com.movies.app.Controller.ApiControllers;


import com.movies.app.Controller.Repository.CountryRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CountryControllers {

    @Autowired
    private CountryRepo countryRepo;

    // get all countries
    @GetMapping(value = "/countries")
    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

    //create country Rest API
    @PostMapping("/countries")
    public Country createCountry(@RequestBody Country country){
        return countryRepo.save(country);
    }
    //get country by id
    @GetMapping(value = "/countries/{id}")
    public ResponseEntity<Country> getContryById(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        return ResponseEntity.ok(country);
    }

    // update country Rest API
    @PutMapping(value = "/countries/{id}")
    public ResponseEntity<Country> updateContry(@PathVariable int id,@RequestBody Country countryDetails){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));


        countryDetails.setCountry(country.getCountry());
        country.setLastUpdate(country.getLastUpdate());
        country.setCities(country.getCities());

        countryRepo.save(countryDetails);
        return ResponseEntity.ok(country);
    }

    // delete country from rest API
    @DeleteMapping(value = "/countries/{id}")
    public  ResponseEntity<HttpStatus> deleteCountry(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        countryRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
