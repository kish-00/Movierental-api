package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Rental;
import com.movies.app.Controller.Repository.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private final RentalRepo rentalRepo;

    public RentalService(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    //creates a rental
    public Rental addRental(Rental rental){
        return rentalRepo.save(rental);
    }

    //create a list of rental

    //read a list of all the rental
    public List<Rental> getAllRentals(){
        return rentalRepo.findAll();
    }

    //reads a rental by its id
    public Rental getRentalById(int id){
        return rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id "+id+" does not exit."));
    }

    //update rental
    public Rental updateRental(int id, Rental rentalInfo){
        Rental rental=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));

        rental.setRentalDate(rentalInfo.getRentalDate());
        rental.setReturnDate(rentalInfo.getReturnDate());

        return rentalRepo.save(rental);
    }

    // delete rental
    public  String deleteRental(int id){
        Rental film=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));
        rentalRepo.delete(film);
        return "Rental with id "+id+" has been deleted!";
    }
}
