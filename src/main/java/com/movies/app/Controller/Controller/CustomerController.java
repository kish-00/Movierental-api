package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Customer;
import com.movies.app.Controller.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //adds a customer
    @PostMapping("/addCustomer")
    public Customer handleAddCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //gets all customers
    @GetMapping("/customers")
    public List<Customer> handleGetAllCustomers(){
        return customerService.getAllCustomers();
    }

    //gets a customer by its id
    @GetMapping("/customer/{id}")
    public Customer handleGetCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    //get customer by first name
    @GetMapping("/customer/{firstName}")
    public Customer handleGetCustomerByFirstName(@PathVariable String firstName){
        return customerService.getCustomerByFirstName(firstName);
    }

    //get customer by last name
    @GetMapping("/customer/{lastName}")
    public Customer handleGetCustomerByLastName(@PathVariable String lastname){
        return customerService.getCustomerByLastName(lastname);
    }

    //update customer Rest API
    @PutMapping("/updateCustomer/{id}")
    public Customer handleUpdateCustomer(int id, Customer customerInfo){
        return customerService.updateCustomer(id, customerInfo);
    }

    // delete customer from rest API
    @DeleteMapping("/deleteCustomer/{id}")
    public String handleDeleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
