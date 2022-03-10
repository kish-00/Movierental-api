package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.City;
import com.movies.app.Controller.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //adds a city
    @PostMapping(value = "/addCity", consumes = "application/JSON")
    public City handleAddCity(@RequestBody City city){
        return cityService.addCity(city);
    }

//add multiple cities

    //gets all cities
    @GetMapping(value = "/cities", produces = "application/JSON")
    public List<City> handleGetAllCities(){
        return cityService.getAllCities();
    }

    //gets a city by its id
    @GetMapping(value = "/city/{id}", consumes = "application/JSON", produces = "application/JSON")
    public City handleGetCityById(@PathVariable int id){
        return cityService.getCityById(id);
    }

    //update city Rest API
    @PutMapping(value = "/updateCity/{id}", consumes = "application/JSON", produces = "application/JSON")
    public City handleUpdateCity(int id, City cityInfo){
        return cityService.updateCity(id, cityInfo);
    }

    // delete city from rest API
    @DeleteMapping(value = "/deleteCity/{id}")
    public String handleDeleteCity(@PathVariable int id){
        return cityService.deleteCity(id);
    }
}
