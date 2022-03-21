package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff,Integer> {
    Staff findByFirstName(String firstName);
    Staff findByLastName(String lastName);
    Staff findByUsername(String username);
}
