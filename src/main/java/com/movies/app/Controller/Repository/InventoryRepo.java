package com.movies.app.Controller.Repository;

import com.movies.app.Controller.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
