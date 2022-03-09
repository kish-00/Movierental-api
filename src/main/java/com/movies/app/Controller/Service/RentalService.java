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
    public ResponseEntity<Rental> getRentalById(int id){
        Rental rental=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id "+id+" does not exit."));
        return ResponseEntity.ok(rental);
    }

    //update rental
    public ResponseEntity<Rental> updateFilms(int id, Rental rentalInfo){
        Rental rental=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));

        rental.setRentalDate(rentalInfo.getRentalDate());
        rental.setReturnDate(rentalInfo.getReturnDate());

        rentalRepo.save(rental);
        return ResponseEntity.ok(rental);
    }

    // delete rental
    public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Rental film=rentalRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Rental with id:" + id+" does not exist."));
        rentalRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}