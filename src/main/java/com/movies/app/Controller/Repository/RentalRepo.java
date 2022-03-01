package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental,Integer> {
}
