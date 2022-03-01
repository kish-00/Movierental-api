package com.movies.app.Controller.ApiControllers;

import com.movies.app.Controller.Repository.LanguageRepo;
import com.movies.app.Controller.Repository.PaymentRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;

//import com.movies.app.Controller.model.Language;
import com.movies.app.Controller.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "/")
public class PaymentController {
    @Autowired
    private PaymentRepo paymentRepo;

    // get all countries
    @GetMapping(value = "/payment")
    public List<Payment> getAllLanguage(){
        return paymentRepo.findAll();

    }
    //create Employee Rest API
    @PostMapping("/payment")
    public Payment createFilm(@RequestBody Payment film){
        return paymentRepo.save(film);
    }
    //get countries by id
    @GetMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> getFilmById(@PathVariable int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));
        return ResponseEntity.ok(film);
    }

    // update country Rest API
    @PutMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> updateFilms(@PathVariable int id,@RequestBody Payment filmDetails){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));
        filmDetails.setAmount(film.getAmount());
        film.setPaymentDate(film.getPaymentDate());
//        customer.setActive(customer.getActive());
        paymentRepo.save(filmDetails);
        return ResponseEntity.ok(film);
    }
    // delete country from rest API
    @DeleteMapping(value = "/payment/{id}")
    public  ResponseEntity<HttpStatus> deleteFilms(@PathVariable int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not exist with id:" + id));
        paymentRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
