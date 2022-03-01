package com.movies.app.Controller.ApiControllers;


import com.movies.app.Controller.Repository.CustomerRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CustomerController {


    @Autowired
    private CustomerRepo customerRepo;

    // get all countries
    @GetMapping(value = "/customers")
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    //create Employee Rest API
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }
    //get countries by id
    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> getContryById(@PathVariable int id){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        return ResponseEntity.ok(customer);
    }

    // update country Rest API
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customerDetails){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerDetails.setAddressColumn(customer.getAddressColumn());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
//        customer.setActive(customer.getActive());
        customer.setCreate_Date(customer.getCreate_Date());

        customerRepo.save(customerDetails);
        return ResponseEntity.ok(customer);
    }
    // delete country from rest API
    @DeleteMapping(value = "/customers/{id}")
    public  ResponseEntity<HttpStatus> deleteCountry(@PathVariable int id){
        Customer country=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
