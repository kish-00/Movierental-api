package com.movies.app.Controller.Controller;


import com.movies.app.Controller.Repository.CategoryRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CategoryController {

    @Autowired

    private CategoryRepo categoryRepo;
    // get all categories
    @GetMapping(value = "/categories")
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }
    //create category Rest API
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryRepo.save(category);

    }

    //get category by id
    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not exist with id:" + id));
        return ResponseEntity.ok(category);
    }

    // update category Rest API
    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category categoryDetails){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not exist with id:" + id));

        categoryDetails.setName(category.getName());
        category.setLastUpdate(category.getLastUpdate());

        categoryRepo.save(categoryDetails);
        return ResponseEntity.ok(category);
    }

    // delete category from rest API
    @DeleteMapping(value = "/categories/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Categories not exist with id:" + id));
        categoryRepo.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
