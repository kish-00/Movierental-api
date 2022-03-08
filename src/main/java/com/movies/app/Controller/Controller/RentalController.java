package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.RentalRepo;
import com.movies.app.Controller.Model.Rental;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class RentalController {

    @Autowired
    private RentalRepo rentalRepo;

    // get all rentals
    @GetMapping(value = "/rental", consumes = "application/JSON", produces = "application/JSON")
    public List<Rental> getAllLanguage(){
        return rentalRepo.findAll();

    }

    //create rental
    @PostMapping(value = "/rental", consumes = "application/JSON", produces = "application/JSON")
    public Rental createFilm(@RequestBody Rental film){
        return rentalRepo.save(film);
    }

    //get rental by id
    @GetMapping(value = "/rental/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Rental> getFilmById(@PathVariable int id){
        Rental film=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" +id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update rental
    @PutMapping(value = "/rental/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Rental> updateFilms(@PathVariable int id,@RequestBody Rental filmInfo){
        Rental film=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));

        film.setRentalDate(filmInfo.getRentalDate());
        film.setReturnDate(filmInfo.getReturnDate());

        rentalRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete rental
    @DeleteMapping(value = "/rental/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Rental film=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));
        rentalRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
