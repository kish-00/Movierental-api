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
    @PostMapping("/addInventory")
    public Inventory handleAddInventory(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }

//add multiple inventories

    //gets all inventories
    @GetMapping("/inventories")
    public List<Inventory> handleGetAllInventories(){
        return inventoryService.getAllInventory();
    }

    //gets an inventory by its id
    @GetMapping("/inventory/{id}")
    public Inventory handleGetInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }

    //update inventory Rest API
    @PutMapping("/updateInventory/{id}")
    public Inventory handleUpdateInventory(int id, Inventory inventoryInfo){
        return inventoryService.updateInventory(id, inventoryInfo);
    }

    // delete inventory from rest API
    @DeleteMapping("/deleteInventory/{id}")
    public String handleDeleteInventory(@PathVariable int id){
        return inventoryService.deleteInventory(id);
    }
}
