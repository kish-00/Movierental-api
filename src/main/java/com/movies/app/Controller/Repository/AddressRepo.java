package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Address;
//import com.movies.app.Controller.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
