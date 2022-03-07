package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int rentalID;

    @Column(name = "rentalDate")
    private Date rentalDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;



    @ManyToOne
    private Staff staff1;

    @ManyToOne
    private Customer customer;

}
