package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Store;
import com.movies.app.Controller.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    //adds a store
    @PostMapping("/addStore")
    public Store handleAddStore(@RequestBody Store store){
        return storeService.addStore(store);
    }

    //gets all stores
    @GetMapping("/stores")
    public List<Store> handleGetAllStores(){
        return storeService.getAllStore();
    }

    //gets a store by its id
    @GetMapping("/storeId/{id}")
    public Store handleGetStoreById(@PathVariable int id){
        return storeService.getStoreById(id);
    }

    //update store Rest API
    @PutMapping("/updateStore/{id}")
    public Store handleUpdateStore(@PathVariable int id, @RequestBody Store storeInfo){
        return storeService.updateStore(id, storeInfo);
    }

    // delete store from rest API
    @DeleteMapping("/deleteStore/{id}")
    public String handleDeleteStore(@PathVariable int id){
        return storeService.deleteStore(id);
    }
}
