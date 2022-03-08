package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.CategoryRepo;
import com.movies.app.Controller.Model.Category;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    // get all categories
    @GetMapping(value = "/categories", produces = "application/JSON")
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    //create category
    @PostMapping(value = "/categories", consumes = "application/JSON")
    public Category createCategory(@RequestBody Category category){
        return categoryRepo.save(category);
    }

    //get category by id
    @GetMapping(value = "/categories/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with id:" + id+" does not exist"));
        return ResponseEntity.ok(category);
    }

    //update category
    @PutMapping(value = "/categories/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category categoryInfo){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with id:" +id+" does not exist."));

        category.setName(categoryInfo.getName());
        category.setLastUpdate(categoryInfo.getLastUpdate());

        categoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    //delete category
    @DeleteMapping(value = "/categories/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Categories with id:" + id+"does not exist."));
        categoryRepo.delete(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
