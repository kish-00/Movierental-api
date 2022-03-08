package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.PaymentRepo;
import com.movies.app.Controller.Model.Payment;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PaymentController {

    @Autowired
    private PaymentRepo paymentRepo;

    // get all payments
    @GetMapping(value = "/payment", consumes = "application/JSON", produces = "application/JSON")
    public List<Payment> getAllLanguage(){
        return paymentRepo.findAll();

    }

    //create payment
    @PostMapping(value = "/payment", consumes = "application/JSON", produces = "application/JSON")
    public Payment createFilm(@RequestBody Payment film){
        return paymentRepo.save(film);
    }

    //get payment by id
    @GetMapping(value = "/payment/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Payment> getFilmById(@PathVariable int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));
        return ResponseEntity.ok(film);
    }

    // update payment
    @PutMapping(value = "/payment/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Payment> updateFilms(@PathVariable int id,@RequestBody Payment filmInfo){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));

        film.setAmount(filmInfo.getAmount());
        film.setPaymentDate(filmInfo.getPaymentDate());

        paymentRepo.save(film);
        return ResponseEntity.ok(film);
    }

    // delete payment
    @DeleteMapping(value = "/payment/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));
        paymentRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
