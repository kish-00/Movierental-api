package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Payment;
import com.movies.app.Controller.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private final PaymentRepo paymentRepo;

    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    //creates a payment
    public Payment addPayment(Payment payment){
        return paymentRepo.save(payment);
    }

    //create a list of payments

    //read a list of all the payments
    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    //reads a payment by its id
    public ResponseEntity<Payment> getPaymentById(int id){
        Payment payment=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id "+id+" does not exit."));
        return ResponseEntity.ok(payment);
    }

    //update payment
    public ResponseEntity<Payment> updateFilms(int id, Payment paymentInfo){
        Payment payment=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));

        payment.setAmount(paymentInfo.getAmount());
        payment.setPaymentDate(paymentInfo.getPaymentDate());

        paymentRepo.save(payment);
        return ResponseEntity.ok(payment);
    }

    // delete payment
    public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));
        paymentRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
