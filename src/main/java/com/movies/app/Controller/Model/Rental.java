package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int rentalID;

    @Column(name = "rentalDate", nullable = false)
    private Date rentalDate;

    @Column(name = "returnDate", nullable = false)
    private Date returnDate;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;



    @ManyToOne
    private Staff staff;

    @ManyToOne
    private Customer customer;

}
