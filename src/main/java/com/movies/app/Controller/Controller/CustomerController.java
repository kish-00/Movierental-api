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
    @PostMapping(value = "/addCustomer", consumes = "application/JSON")
    public Customer handleAddCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //gets all customers
    @GetMapping(value = "/customers", produces = "application/JSON")
    public List<Customer> handleGetAllCustomers(){
        return customerService.getAllCustomers();
    }

    //gets a customer by its id
    @GetMapping(value = "/customer/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Customer handleGetCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    //get customer by first name
    @GetMapping(value = "/customer/{firstName}", produces = "application/json")
    public Customer handleGetCustomerByFirstName(@PathVariable String firstName){
        return customerService.getCustomerByFirstName(firstName);
    }

    //get customer by last name
    @GetMapping(value = "/customer/{lastName}", produces = "application/json")
    public Customer handleGetCustomerByLastName(@PathVariable String lastname){
        return customerService.getCustomerByLastName(lastname);
    }

    //update customer Rest API
    @PutMapping(value = "/updateCustomer/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Customer handleUpdateCustomer(int id, Customer customerInfo){
        return customerService.updateCustomer(id, customerInfo);
    }

    // delete customer from rest API
    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String handleDeleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
