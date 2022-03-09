package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Store;
import com.movies.app.Controller.Repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private final StoreRepo storeRepo;

    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }

    //creates a store
    public Store addStore(Store store){
        return storeRepo.save(store);
    }

    //create a list of store

    //read a list of all the stores
    public List<Store> getAllStore(){
        return storeRepo.findAll();
    }

    //reads a store by its id
    public ResponseEntity<Store> getStoreById(int id){
        Store store=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id "+id+" does not exit."));
        return ResponseEntity.ok(store);
    }

    //update Store
    public ResponseEntity<Store> updateFilms(int id, Store storeInfo){
        Store store=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));

        store.setLastUpdated(storeInfo.getLastUpdated());

        storeRepo.save(store);
        return ResponseEntity.ok(store);
    }

    // delete store
    @DeleteMapping(value = "/stores/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Store store=storeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Store with id:" + id+" does not exist."));
        storeRepo.delete(store);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
