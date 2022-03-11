package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    Address findByAddress(String address);
}
