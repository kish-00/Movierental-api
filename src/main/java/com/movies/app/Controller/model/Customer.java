package com.movies.app.Controller.model;

//import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int customerID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "emaill")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "lastUpdated")
    private Timestamp last_Updated;

    @Column(name = "addressColumn")
    private int addressColumn;

    @Column(name = "create_Date")
    private Timestamp create_Date;

    @ManyToOne
    private Address address1;



    @OneToMany(mappedBy = "customer1")
    private List<Rental> rentals = new ArrayList<Rental>();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getLast_Updated() {
        return last_Updated;
    }

    public void setLast_Updated(Timestamp last_Updated) {
        this.last_Updated = last_Updated;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    public int getAddressColumn() {
        return addressColumn;
    }

    public void setAddressColumn(int addressColumn) {
        this.addressColumn = addressColumn;
    }

    public Timestamp getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        this.create_Date = create_Date;
    }


//    public List<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(List<Payment> payments) {
//        this.payments = payments;
//    }


    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public void makePayment() {

    }

    @Override
    public void rent() {

    }
}
