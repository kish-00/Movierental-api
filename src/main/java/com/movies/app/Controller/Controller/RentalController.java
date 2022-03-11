package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Rental;
import com.movies.app.Controller.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    //adds a rental
    @PostMapping(value = "/addRental", consumes = "application/JSON")
    public Rental handleAddRental(@RequestBody Rental rental){
        return rentalService.addRental(rental);
    }

    //gets all rentals
    @GetMapping(value = "/rentals", produces = "application/JSON")
    public List<Rental> handleGetAllRentals(){
        return rentalService.getAllRentals();
    }

    //gets a rental by its id
    @GetMapping(value = "/rental/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Rental handleGetRentalById(@PathVariable int id){
        return rentalService.getRentalById(id);
    }

    //update rental Rest API
    @PutMapping(value = "/updateRental/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Rental handleUpdateRental(int id, Rental rentalInfo){
        return rentalService.updateRental(id, rentalInfo);
    }

    // delete rental from rest API
    @DeleteMapping(value = "/deleteRental/{id}")
    public String handleDeleteRental(@PathVariable int id){
        return rentalService.deleteRental(id);
    }
}
