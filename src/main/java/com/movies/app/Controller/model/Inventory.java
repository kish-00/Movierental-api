package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int inventoryID;

    @Column(name = "lastUpdated")
    private Timestamp lastUpdated;


    @ManyToOne
    private Film filmInventory;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
