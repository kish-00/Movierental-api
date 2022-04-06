package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "lastUpdated", nullable = false)
    private Timestamp lastUpdated;

    @JsonIgnore
    @ManyToOne
    private Film filmInventory;

}
