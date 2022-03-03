package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "emaill")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @Column(name = "address")
    private int addressColumn;

    @Column(name = "createDate")
    private Timestamp createDate;

    @ManyToOne
    private Address address;



    @OneToMany(mappedBy = "customer")
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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLast_Updated(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerID(int customerId) {
        this.customerId = customerId;
    }


    public int getAddressColumn() {
        return addressColumn;
    }

    public void setAddressColumn(int addressColumn) {
        this.addressColumn = addressColumn;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreate_Date(Timestamp createDate) {
        this.createDate = createDate;
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
