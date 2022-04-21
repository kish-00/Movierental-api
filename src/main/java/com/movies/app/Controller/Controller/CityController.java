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
    @PostMapping("/addCity")
    public City handleAddCity(@RequestBody City city){
        return cityService.addCity(city);
    }

    //gets all cities
    @GetMapping("/getcities")
    public List<City> handleGetAllCities(){
        return cityService.getAllCities();
    }

    //gets a city by its id
    @GetMapping("/getCityId/{id}")
    public City handleGetCityById(@PathVariable int id){
        return cityService.getCityById(id);
    }

    //gets city by name
    @GetMapping("/getCityName/{name}")
    public City handleGetCityByName (@PathVariable String name){
        return cityService.getCityByName(name);
    }

    //update city Rest API
    @PutMapping("/updateCity/{id}")
    public City handleUpdateCity(@PathVariable int id, @RequestBody City cityInfo){
        return cityService.updateCity(id, cityInfo);
    }

    // delete city from rest API
    @DeleteMapping("/deleteCity/{id}")
    public String handleDeleteCity(@PathVariable int id){
        return cityService.deleteCity(id);
    }
}
