package com.movies.app.Controller.model;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


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
    private Customer customer1;



    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
