package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
}
