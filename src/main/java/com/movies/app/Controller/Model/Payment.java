package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    private Rental rental;

    @JsonIgnore
    @ManyToOne
    private Customer customer;
    @JsonIgnore
    @ManyToOne
    private Staff staff;

  }
