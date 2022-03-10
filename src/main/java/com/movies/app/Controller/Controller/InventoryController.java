package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Inventory;
import com.movies.app.Controller.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    //adds an inventory
    @PostMapping(value = "/addInventory", consumes = "application/JSON")
    public Inventory handleAddInventory(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }

//add multiple inventories

    //gets all inventories
    @GetMapping(value = "/inventories", produces = "application/JSON")
    public List<Inventory> handleGetAllInventories(){
        return inventoryService.getAllInventory();
    }

    //gets an inventory by its id
    @GetMapping(value = "/inventory/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Inventory handleGetInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }

    //update inventory Rest API
    @PutMapping(value = "/updateInventory/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Inventory handleUpdateInventory(int id, Inventory inventoryInfo){
        return inventoryService.updateInventory(id, inventoryInfo);
    }

    // delete inventory from rest API
    @DeleteMapping(value = "/deleteInventory/{id}")
    public String handleDeleteInventory(@PathVariable int id){
        return inventoryService.deleteInventory(id);
    }
}
