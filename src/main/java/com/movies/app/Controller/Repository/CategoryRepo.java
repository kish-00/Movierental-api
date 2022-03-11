package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
