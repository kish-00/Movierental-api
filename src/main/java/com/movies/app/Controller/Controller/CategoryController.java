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
    @PostMapping("/addCategory")
    public Category handleAddCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    //gets all categories
    @GetMapping("/categories")
    public List<Category> handleGetAllCategories(){
        return categoryService.getAllCategories();
    }

    //gets a category by its id
    @GetMapping("/category/{id}")
    public Category handleGetCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    //get category by name of category
    @GetMapping("/category/{name}")
    public Category handleGetCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }

    //update category Rest API
    @PutMapping("/updateCategory/{id}")
    public Category handleUpdateCategory(int id, Category categoryInfo){
        return categoryService.updateCategory(id, categoryInfo);
    }

    // delete category from rest API
    @DeleteMapping("/deleteCategory/{id}")
    public String handleDeleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }
}
