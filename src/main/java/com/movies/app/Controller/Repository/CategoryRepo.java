package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Category;
//import com.movies.app.Controller.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
