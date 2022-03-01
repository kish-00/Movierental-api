package com.movies.app.Controller.ApiControllers;

import com.movies.app.Controller.Repository.FilmRepo;
import com.movies.app.Controller.Repository.InventoryRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Inventory;
import com.movies.app.Controller.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class InventoryController {


    @Autowired
    private InventoryRepo inventoryRepo;

    // get all countries
    @GetMapping(value = "/inventory")
    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }
    //create Employee Rest API
    @PostMapping("/inventory")
    public Inventory createFilm(@RequestBody Inventory inventory){
        return inventoryRepo.save(inventory);
    }
    //get countries by id
    @GetMapping(value = "/inventory/{id}")
    public ResponseEntity<Inventory> getFilmById(@PathVariable int id){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        return ResponseEntity.ok(inventory);
    }

    // update country Rest API
    @PutMapping(value = "/inventory/{id}")
    public ResponseEntity<Inventory> updateFilms(@PathVariable int id,@RequestBody Inventory inventoryDetails){
        Inventory inventory=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        inventoryDetails.setLastUpdated(inventory.getLastUpdated());

//        customer.setActive(customer.getActive());
        inventoryRepo.save(inventoryDetails);
        return ResponseEntity.ok(inventory);
    }
    // delete country from rest API
    @DeleteMapping(value = "/inventory/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Inventory film=inventoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Inventory not exist with id:" + id));
        inventoryRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
