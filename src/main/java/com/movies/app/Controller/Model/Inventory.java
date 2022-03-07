package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int inventoryId;

    @Column(name = "lastUpdated")
    private Timestamp lastUpdated;


    @ManyToOne
    private Film filmInventory;

}
