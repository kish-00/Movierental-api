package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Payment;
import com.movies.app.Controller.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Payment getPaymentById(int id){
        return paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id "+id+" does not exit."));
    }

    //update payment
    public Payment updatePayment(int id, Payment paymentInfo){
        Payment payment=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));

        payment.setAmount(paymentInfo.getAmount());
        payment.setPaymentDate(paymentInfo.getPaymentDate());

        return paymentRepo.save(payment);
    }

    // delete payment
    public  String deletePayment(int id){
        Payment film=paymentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment with id:" + id+" does not exist."));
        paymentRepo.delete(film);
        return "Film id "+id+"has been deleted!";
    }
}
