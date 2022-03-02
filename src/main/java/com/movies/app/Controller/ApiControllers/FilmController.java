package com.movies.app.Controller.ApiControllers;


import com.movies.app.Controller.Repository.FilmRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FilmController {

    @Autowired
    private FilmRepo filmRepo;

    // get all films
    @GetMapping(value = "/films")
    public List<Film> getAllFilms(){
        return filmRepo.findAll();
    }
    //create film Rest API
    @PostMapping("/films")
    public Film createFilm(@RequestBody Film film){
        return filmRepo.save(film);
    }
    //get film by id
    @GetMapping(value = "/films/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // update film Rest API
    @PutMapping(value = "/films/{id}")
    public ResponseEntity<Film> updateFilms(@PathVariable int id,@RequestBody Film filmDetails){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        filmDetails.setTitle(film.getTitle());
        film.setDescription(film.getDescription());
        film.setReleaseYear(film.getReleaseYear());
        film.setRentalDuration(film.getRentalDuration());

        film.setRentalRate(film.getRentalRate());
        film.setLength(film.getLength());
        film.setReplacementCost(film.getReplacementCost());
        film.setRating(film.getRating());
        film.setLast_update(film.getLast_update());
        film.setSpecialFeatures(film.getSpecialFeatures());
        film.setFulltext(film.getFulltext());

//        customer.setActive(customer.getActive());
        filmRepo.save(filmDetails);
        return ResponseEntity.ok(film);
    }
    // delete film from rest API
    @DeleteMapping(value = "/films/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film not exist with id:" + id));
        filmRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
