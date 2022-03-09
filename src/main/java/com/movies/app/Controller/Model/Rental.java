package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

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
