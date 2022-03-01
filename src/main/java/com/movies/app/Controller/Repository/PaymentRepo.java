package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
