package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film,Integer> {
}
