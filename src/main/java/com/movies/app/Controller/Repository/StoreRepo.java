package com.movies.app.Controller.Repository;

import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store,Integer> {
}
