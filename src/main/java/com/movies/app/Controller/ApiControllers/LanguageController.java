package com.movies.app.Controller.ApiControllers;

import com.movies.app.Controller.Repository.LanguageRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;

//import com.movies.app.Controller.model.Language;
import com.movies.app.Controller.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class LanguageController {


    @Autowired
    private LanguageRepo languageRepo;


    // get all languages
    @GetMapping(value = "/language")
    public List<Language> getAllLanguage(){
        return languageRepo.findAll();

    }
    //create language Rest API
    @PostMapping("/language")
    public Language createFilm(@RequestBody Language film){
        return languageRepo.save(film);
    }
    //get language by id
    @GetMapping(value = "/language/{id}")
    public ResponseEntity<Language> getFilmById(@PathVariable int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // update country Rest API
    @PutMapping(value = "/language/{id}")
    public ResponseEntity<Language> updateFilms(@PathVariable int id,@RequestBody Language filmDetails){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));
        filmDetails.setName(film.getName());
        film.setLastUpdate(film.getLastUpdate());
//        customer.setActive(customer.getActive());
        languageRepo.save(filmDetails);
        return ResponseEntity.ok(film);
    }
    // delete language from rest API
    @DeleteMapping(value = "/language/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language not exist with id:" + id));
        languageRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
