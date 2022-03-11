package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Customer;
import com.movies.app.Controller.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Customer getCustomerById(int id){
        return customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id "+id+" does not exit."));
    }

    //reads an actor by their first name
    public Customer getCustomerByFirstName(String firstName) {
        return customerRepo.findByFirstName(firstName);
    }

    //reads an actor by the last name
    public Customer getCustomerByLastName(String lastName) {
        return customerRepo.findByLastName(lastName);
    }

    //update customer
    public Customer updateCustomer(int id, Customer customerInfo){
        Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id:"+id+" does not exist."));
        customer.setAddressColumn(customerInfo.getAddressColumn());
        customer.setFirstName(customerInfo.getFirstName());
        customer.setLastName(customerInfo.getLastName());
        customer.setEmail(customerInfo.getEmail());
        customer.setCreateDate(customerInfo.getCreateDate());

        return customerRepo.save(customer);
    }

    // delete customer
    public  String deleteCustomer(int id){
        Customer country=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not exist with id:" + id));
        customerRepo.delete(country);
        return "Country with id "+id+" has been deleted";
    }
}
