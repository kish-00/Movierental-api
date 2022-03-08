package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.FilmRepo;
import com.movies.app.Controller.Model.Film;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FilmController {

    @Autowired
    private FilmRepo filmRepo;

    // get all films
    @GetMapping(value = "/films", consumes = "application/JSON", produces = "application/JSON")
    public List<Film> getAllFilms(){
        return filmRepo.findAll();
    }

    //create film
    @PostMapping("/films")
    public Film createFilm(@RequestBody Film film){
        return filmRepo.save(film);
    }

    //get film by id
    @GetMapping(value = "/films/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Film> getFilmById(@PathVariable int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id:"+id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update film
    @PutMapping(value = "/films/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Film> updateFilms(@PathVariable int id,@RequestBody Film filmInfo){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id:"+id+" does not exist."));

        film.setTitle(filmInfo.getTitle());
        film.setDescription(filmInfo.getDescription());
        film.setReleaseYear(filmInfo.getReleaseYear());
        film.setRentalDuration(filmInfo.getRentalDuration());
        film.setRentalRate(filmInfo.getRentalRate());
        film.setLength(filmInfo.getLength());
        film.setReplacementCost(filmInfo.getReplacementCost());
        film.setRating(filmInfo.getRating());
        film.setLastUpdate(filmInfo.getLastUpdate());
        film.setSpecialFeatures(filmInfo.getSpecialFeatures());
        film.setFullTxt(filmInfo.getFullTxt());

        filmRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete film from rest API
    @DeleteMapping(value = "/films/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Film film=filmRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Film with id: "+id+" does not exist."));
        filmRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
