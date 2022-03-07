package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff implements rentalInterface,paymentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int staffId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "lastUpdated")
    private Timestamp lastUpdated;

    @Column(name = "paymentId")
    private int paymentId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "pictureUrl")
    private String pictureUrl;


    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;

    @ManyToOne
    private Address address;

    @ManyToOne
    private Store store;

//    @OneToMany(mappedBy = "staff1")
//    private List<Payment> payments;

    @Override
    public void makePayment() {

    }

    @Override
    public void rent() {

    }
}
