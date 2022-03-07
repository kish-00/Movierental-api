package com.movies.app.Controller.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int paymentId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "paymentDate")
    private Date paymentDate;


    @ManyToOne
    private Rental rental;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Staff staff1;

  }
