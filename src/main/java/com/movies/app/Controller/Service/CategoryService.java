package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Category;
import com.movies.app.Controller.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    //creates a category
    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }


    //read a list of all the categories
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    //reads a category by its id
    public Category getCategoryById(int id){
        return categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with id "+id+" does not exit."));
    }

    //reads a category by its name
    public Category getCategoryByName(String name){
        return categoryRepo.findByName(name);
    }

    //update category Rest API
    public Category updateCategory(int id, Category categoryInfo){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category with id:" +id+" does not exist."));

        category.setName(categoryInfo.getName());
        category.setLastUpdate(categoryInfo.getLastUpdate());

        return categoryRepo.save(category);
    }

    //delete category
    public  String deleteCategory(@PathVariable int id){
        Category category= categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Categories with id:" + id+"does not exist."));
        categoryRepo.delete(category);
        return "Category with id "+id+" has been deleted!";
    }
}
