package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Integer> {
    Country findByName(String name);
}
