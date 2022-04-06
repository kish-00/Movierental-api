package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @Column(name = "address", nullable = false)
    private int addressColumn;

    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;

    @JsonIgnore
    @ManyToOne
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals = new ArrayList<Rental>();

    public void makePayment() {

    }

    @Override
    public void rent() {

    }
}
