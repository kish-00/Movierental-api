package com.movies.app.Controller.model;

//import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "Staff")
public class Staff implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int staffID;



    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "lastUpdated")
    private Timestamp last_Updated;



    @Column(name = "paymentID")
    private int paymentID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "pictreUrl")
    private String pictureURL;


    @OneToMany(mappedBy = "staff1")
    private List<Rental> rentals;

    @ManyToOne
    private Address address1;

    @ManyToOne
    private Store store1;

//    @OneToMany(mappedBy = "staff1")
//    private List<Payment> payments;


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

    public Store getStore1() {
        return store1;
    }

    public void setStore1(Store store1) {
        this.store1 = store1;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }


    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }



    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    @Override
    public void makePayment() {

    }

    @Override
    public void rent() {

    }
}
