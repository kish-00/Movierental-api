package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.LanguageRepo;
import com.movies.app.Controller.Model.Language;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class LanguageController {

    @Autowired
    private LanguageRepo languageRepo;

    // get all languages
    @GetMapping(value = "/language", consumes = "application/JSON", produces = "application/JSON")
    public List<Language> getAllLanguage(){
        return languageRepo.findAll();
    }

    //create language
    @PostMapping(value = "/language", consumes = "application/JSON")
    public Language createFilm(@RequestBody Language film){
        return languageRepo.save(film);
    }

    //get language by id
    @GetMapping(value = "/language/{id}", produces = "application/JSON")
    public ResponseEntity<Language> getFilmById(@PathVariable int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:"+id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update country
    @PutMapping(value = "/language/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Language> updateFilms(@PathVariable int id,@RequestBody Language filmInfo){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:"+id+" does not exist."));

        film.setName(filmInfo.getName());
        film.setLastUpdate(filmInfo.getLastUpdate());

        languageRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete language
    @DeleteMapping(value = "/language/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:" + id+" does not exist."));
        languageRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
