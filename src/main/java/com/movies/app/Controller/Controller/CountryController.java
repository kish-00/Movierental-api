package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.CountryRepo;
import com.movies.app.Controller.Model.Country;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CountryController {

    @Autowired
    private CountryRepo countryRepo;

    // get all countries
    @GetMapping(value = "/countries", consumes = "application/JSON", produces = "application/JSON")
    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

    //create country
    @PostMapping(value = "/countries", consumes = "application/JSON")
    public Country createCountry(@RequestBody Country country){
        return countryRepo.save(country);
    }

    //get country by id
    @GetMapping(value = "/countries/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Country> getCountryById(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country with id: "+id+" does not exist."));
        return ResponseEntity.ok(country);
    }

    // update country
    @PutMapping(value = "/countries/{id}", consumes = "application/JSON")
    public ResponseEntity<Country> updateCountry(@PathVariable int id,@RequestBody Country countryInfo){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country with id:" + id+" does not exist."));

        country.setCountry(countryInfo.getCountry());
        country.setLastUpdate(countryInfo.getLastUpdate());
        country.setCities(countryInfo.getCities());

        countryRepo.save(country);
        return ResponseEntity.ok(country);
    }

    // delete country
    @DeleteMapping(value = "/countries/{id}")
    public  ResponseEntity<HttpStatus> deleteCountry(@PathVariable int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        countryRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
