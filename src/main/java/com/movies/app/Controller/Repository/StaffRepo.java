package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff,Integer> {
}
