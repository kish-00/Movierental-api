package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Inventory;
import com.movies.app.Controller.Repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private final InventoryRepo inventoryRepo;

    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    //creates an inventory
    public Inventory addInventory(Inventory inventory){
        return inventoryRepo.save(inventory);
    }

    //create a list of inventory

    //read a list of all the inventory
    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }

    //reads an inventory by its id
    public ResponseEntity<Inventory> getInventoryById(int id){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory with id "+id+" does not exit."));
        return ResponseEntity.ok(inventory);
    }

    //update inventory
    public ResponseEntity<Inventory> updateFilms(int id, Inventory inventoryInfo){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));

        inventory.setLastUpdated(inventoryInfo.getLastUpdated());

        inventoryRepo.save(inventory);
        return ResponseEntity.ok(inventory);
    }

    // delete inventory from rest API
    public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Inventory film=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory with id:" + id+" does not exist."));
        inventoryRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
