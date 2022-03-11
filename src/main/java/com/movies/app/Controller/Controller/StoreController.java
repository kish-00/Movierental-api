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
    @PostMapping(value = "/addStore", consumes = "application/JSON")
    public Store handleAddStore(@RequestBody Store store){
        return storeService.addStore(store);
    }

    //gets all stores
    @GetMapping(value = "/stores", produces = "application/JSON")
    public List<Store> handleGetAllStores(){
        return storeService.getAllStore();
    }

    //gets a store by its id
    @GetMapping(value = "/store/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Store handleGetStoreById(@PathVariable int id){
        return storeService.getStoreById(id);
    }

    //update store Rest API
    @PutMapping(value = "/updateStore/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Store handleUpdateStore(int id, Store storeInfo){
        return storeService.updateStore(id, storeInfo);
    }

    // delete store from rest API
    @DeleteMapping(value = "/deleteStore/{id}")
    public String handleDeleteStore(@PathVariable int id){
        return storeService.deleteStore(id);
    }
}
