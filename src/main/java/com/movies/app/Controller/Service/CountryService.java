package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Country;
import com.movies.app.Controller.Repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    //creates a country
    public Country addCountry(Country country){
        return countryRepo.save(country);
    }

    //create a list of countries

    //read a list of all the countries
    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

    //reads a country by its id
    public Country getCountryById(int id){
        return countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country with id "+id+" does not exit."));
    }
    //reads country by its name
    public Country getCountryByName(String name){
        return countryRepo.findByName(name);
    }


    //update country
    public Country updateCountry(int id, Country countryInfo){
        Country country= countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country with id:" +id+" does not exist."));

        country.setName(countryInfo.getName());
        country.setLastUpdate(countryInfo.getLastUpdate());
        country.setCities(countryInfo.getCities());

        return countryRepo.save(country);
    }

    // delete country
    public  String deleteCountry(int id){
        Country country=countryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Country not exist with id:" + id));
        countryRepo.delete(country);
        return "Actor with id "+id+" has been deleted";
    }
}
