package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Integer> {
}
