package com.movies.app.Controller.Repository;

//import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
