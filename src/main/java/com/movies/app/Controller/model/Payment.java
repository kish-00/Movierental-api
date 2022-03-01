package com.movies.app.Controller.model;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int paymentID;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "paymentDate")
    private Date paymentDate;


    @ManyToOne
    private Rental rental1;

    @ManyToOne
    private Customer customer1;

    @ManyToOne
    private Staff staff1;


    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
