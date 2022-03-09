package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "lastUpdated", nullable = false)
    private Timestamp lastUpdated;


    @ManyToOne
    private Film filmInventory;

}
