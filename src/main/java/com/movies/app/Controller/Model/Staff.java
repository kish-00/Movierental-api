package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "lastUpdated", nullable = false)
    private Timestamp lastUpdated;

    @Column(name = "paymentId", nullable = false)
    private int paymentId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "pictureUrl", nullable = false)
    private String pictureUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;

    @JsonIgnore
    @ManyToOne
    private Address address;

    @JsonIgnore
    @ManyToOne
    private Store store;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Payment> payments;

    @Override
    public void makePayment() {

    }

    @Override
    public void rent() {

    }
}
