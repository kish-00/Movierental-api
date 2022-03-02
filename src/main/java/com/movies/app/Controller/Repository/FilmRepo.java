package com.movies.app.Controller.Repository;

//import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film,Integer> {
}
