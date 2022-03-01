package com.movies.app.Controller.ApiControllers;

import com.movies.app.Controller.Repository.StoreRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Store;
import com.movies.app.Controller.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class StoreController {

    @Autowired
    private StoreRepo storeRepo;

    // get all countries
    @GetMapping(value = "/stores")
    public List<Store> getAllFilms(){
        return storeRepo.findAll();
    }
    //create Employee Rest API
    @PostMapping("/stores")
    public Store createFilm(@RequestBody Store film){
        return storeRepo.save(film);
    }
    //get countries by id
    @GetMapping(value = "/stores/{id}")
    public ResponseEntity<Store> getFilmById(@PathVariable int id){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // update country Rest API
    @PutMapping(value = "/stores/{id}")
    public ResponseEntity<Store> updateFilms(@PathVariable int id,@RequestBody Store filmDetails){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store not exist with id:" + id));
        filmDetails.setLastUpdated(film.getLastUpdated());
        storeRepo.save(filmDetails);
        return ResponseEntity.ok(film);
    }

    // delete country from rest API
    @DeleteMapping(value = "/stores/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        storeRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
