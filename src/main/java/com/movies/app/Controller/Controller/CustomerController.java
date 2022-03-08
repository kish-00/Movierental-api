package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.CustomerRepo;
import com.movies.app.Controller.Model.Customer;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CustomerController {


    @Autowired
    private CustomerRepo customerRepo;

    // get all customers
    @GetMapping(value = "/customers", consumes = "application/JSON", produces = "application/JSON")
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    //create customer
    @PostMapping(value = "/customers", consumes = "application/JSON")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    //get customer by id
    @GetMapping(value = "/customers/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id:" + id+" does not exist."));
        return ResponseEntity.ok(customer);
    }

    // update customer
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customerInfo){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id:"+id+" does not exist."));
        customer.setAddressColumn(customerInfo.getAddressColumn());
        customer.setFirstName(customerInfo.getFirstName());
        customer.setLastName(customerInfo.getLastName());
        customer.setEmail(customerInfo.getEmail());
        customer.setCreateDate(customerInfo.getCreateDate());

        customerRepo.save(customer);
        return ResponseEntity.ok(customer);
    }

    // delete customer
    @DeleteMapping(value = "/customers/{id}")
    public  ResponseEntity<HttpStatus> deleteCountry(@PathVariable int id){
        Customer country=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
