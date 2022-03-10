package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Category;
import com.movies.app.Controller.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //adds a category
    @PostMapping(value = "/addCategory", consumes = "application/JSON")
    public Category handleAddCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

//add multiple categories

    //gets all categories
    @GetMapping(value = "/categories", produces = "application/JSON")
    public List<Category> handleGetAllCategories(){
        return categoryService.getAllCategories();
    }

    //gets a category by its id
    @GetMapping(value = "/category/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Category handleGetCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    //update category Rest API
    @PutMapping(value = "/updateCategory/{id}")
    public Category handleUpdateCategory(int id, Category categoryInfo){
        return categoryService.updateCategory(id, categoryInfo);
    }

    // delete category from rest API
    @DeleteMapping(value = "/deleteCategory/{id}")
    public String handleDeleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }
}
