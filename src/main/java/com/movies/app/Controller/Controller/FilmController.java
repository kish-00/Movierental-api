package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Film;
import com.movies.app.Controller.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    //adds a film
    @PostMapping(value = "/addFilm", consumes = "application/JSON")
    public Film handleAddFilm(@RequestBody Film film){
        return filmService.addFilm(film);
    }

    //gets all films
    @GetMapping(value = "/films", produces = "application/JSON")
    public List<Film> handleGetAllFilms(){
        return filmService.getAllFilms();
    }

    //gets a film by its id
    @GetMapping(value = "/film/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Film handleGetFilmById(@PathVariable int id){
        return filmService.getFilmById(id);
    }

    //gets film by its title
    @GetMapping(value = "/film/{title}", produces = "application/json")
    public Film handleGetFilmTitle(@PathVariable String title){
        return filmService.getFilmByTitle(title);
    }

    //update film Rest API
    @PutMapping(value = "/updateFilm/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Film handleUpdateFilm(int id, Film filmInfo){
        return filmService.updateFilm(id, filmInfo);
    }

    // delete film from rest API
    @DeleteMapping(value = "/deleteFilm/{id}")
    public String handleDeleteFilm(@PathVariable int id){
        return filmService.deleteFilm(id);
    }
}
