package com.example.MovieRentalSystem.Services;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Customer;
import com.movies.app.Controller.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    //creates a customer
    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    //create a list of customers

    //read a list of all the customers
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    //reads a customer by its id
    public ResponseEntity<Customer> getCustomerById(int id){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id "+id+" does not exit."));
        return ResponseEntity.ok(customer);
    }

    //update customer
    public ResponseEntity<Customer> updateCustomer(int id, Customer customerInfo){
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
    public  ResponseEntity<HttpStatus> deleteCountry(int id){
        Customer country=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerRepo.delete(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
