package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.City;
import com.movies.app.Controller.Repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private final CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    //creates a city
    public City addCity(City city){
        return cityRepo.save(city);
    }

    //create a list of cities

    //read a list of all the cities
    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    //reads a city by its id
    public ResponseEntity<City> getCityById(int id){
        City city=cityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("City with id "+id+" does not exit."));
        return ResponseEntity.ok(city);
    }

    //update city Rest API
    public ResponseEntity<City> updateCity(int id, City cityInfo){
        City city= cityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("City with id:" +id+" does not exist."));

        city.setCountry(cityInfo.getCountry());
        city.setCity(cityInfo.getCity());
        city.setLastUpdate(city.getLastUpdate());

        cityRepo.save(city);
        return ResponseEntity.ok(city);
    }

    //delete category
    public  ResponseEntity<HttpStatus> deleteActor(int id){
        City city= cityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("City with id:" + id+"does not exist."));
        cityRepo.delete(city);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
