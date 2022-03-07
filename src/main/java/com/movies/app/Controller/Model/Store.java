package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  int storeID;

    @Column(name = "lastUpdated")
    private Timestamp lastUpdated;


    @OneToMany(mappedBy = "store")
    private List<Staff> staff;

    @ManyToOne
    Address address;

}
