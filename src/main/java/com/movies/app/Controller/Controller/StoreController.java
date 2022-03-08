package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.StoreRepo;
import com.movies.app.Controller.Model.Store;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StoreController {

    @Autowired
    private StoreRepo storeRepo;

    // get all store
    @GetMapping(value = "/stores", consumes = "application/JSON", produces = "application/JSON")
    public List<Store> getAllFilms(){
        return storeRepo.findAll();
    }

    //create store Rest API
    @PostMapping(value = "/stores", consumes = "application/JSON")
    public Store createFilm(@RequestBody Store film){
        return storeRepo.save(film);
    }

    //get store by id
    @GetMapping(value = "/stores/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Store> getFilmById(@PathVariable int id){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update store
    @PutMapping(value = "/stores/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Store> updateFilms(@PathVariable int id,@RequestBody Store filmInfo){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));

        film.setLastUpdated(filmInfo.getLastUpdated());

        storeRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete store
    @DeleteMapping(value = "/stores/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Store film=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id:" + id+" does not exist."));
        storeRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
