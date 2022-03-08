package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.InventoryRepo;
import com.movies.app.Controller.Model.Inventory;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class InventoryController {

    @Autowired
    private InventoryRepo inventoryRepo;

    // get all inventories
    @GetMapping(value = "/inventory", produces = "application/JSON")
    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }

    //create inventory
    @PostMapping(value = "/inventory", consumes = "application/JSON")
    public Inventory createFilm(@RequestBody Inventory inventory){
        return inventoryRepo.save(inventory);
    }

    //get inventory by id
    @GetMapping(value = "/inventory/{id}")
    public ResponseEntity<Inventory> getFilmById(@PathVariable int id){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory with id:"+id+" does not exist."));
        return ResponseEntity.ok(inventory);
    }

    // update inventory
    @PutMapping(value = "/inventory/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Inventory> updateFilms(@PathVariable int id,@RequestBody Inventory inventoryInfo){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));

        inventory.setLastUpdated(inventoryInfo.getLastUpdated());

        inventoryRepo.save(inventory);
        return ResponseEntity.ok(inventory);
    }

    // delete inventory from rest API
    @DeleteMapping(value = "/inventory/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Inventory film=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory with id:" + id+" does not exist."));
        inventoryRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
