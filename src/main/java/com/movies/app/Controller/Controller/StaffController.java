package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.StaffRepo;
import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StaffController {
    @Autowired
    private StaffRepo staffRepo;

    // get all staff
    @GetMapping(value = "/staff", consumes = "application/JSON", produces = "application/JSON")
    public List<Staff> getAllLanguage(){
        return staffRepo.findAll();
    }

    //create staff
    @PostMapping(value = "/staff", consumes = "application/JSON")
    public Staff createFilm(@RequestBody Staff film){
        return staffRepo.save(film);
    }

    //get staff by id
    @GetMapping(value = "/staff/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Staff> getFilmById(@PathVariable int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update staff
    @PutMapping(value = "/staff/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Staff> updateFilms(@PathVariable int id,@RequestBody Staff filmInfo){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));

        film.setPaymentId(filmInfo.getPaymentId());
        film.setFirstName(filmInfo.getFirstName());
        film.setLastName(filmInfo.getLastName());
        film.setEmail(filmInfo.getEmail());
        film.setUsername(filmInfo.getUsername());
        film.setPassword(filmInfo.getPassword());
        film.setLastUpdated(filmInfo.getLastUpdated());
        film.setPictureUrl(filmInfo.getPictureUrl());

        staffRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete staff from rest API
    @DeleteMapping(value = "/staff/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));
        staffRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
