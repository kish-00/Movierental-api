package com.movies.app.Controller.Repository;

//import com.movies.app.Controller.model.Country;
import com.movies.app.Controller.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
