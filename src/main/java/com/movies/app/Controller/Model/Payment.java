package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "paymentDate", nullable = false)
    private Date paymentDate;


    @ManyToOne
    private Rental rental;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Staff staff;

  }
