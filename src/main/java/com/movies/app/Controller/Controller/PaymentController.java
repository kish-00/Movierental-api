package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Payment;
import com.movies.app.Controller.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //adds a payment
    @PostMapping(value = "/addPayment", consumes = "application/JSON")
    public Payment handleAddPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

//add multiple payments

    //gets all payments
    @GetMapping(value = "/payments", produces = "application/JSON")
    public List<Payment> handleGetAllPayments(){
        return paymentService.getAllPayments();
    }

    //gets a payment by its id
    @GetMapping(value = "/payment/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Payment handleGetPaymentById(@PathVariable int id){
        return paymentService.getPaymentById(id);
    }

    //update payment Rest API
    @PutMapping(value = "/updatePayment/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Payment handleUpdatePayment(int id, Payment paymentInfo){
        return paymentService.updatePayment(id, paymentInfo);
    }

    // delete payment from rest API
    @DeleteMapping(value = "/deletePayment/{id}")
    public String handleDeletePayment(@PathVariable int id){
        return paymentService.deletePayment(id);
    }
}
