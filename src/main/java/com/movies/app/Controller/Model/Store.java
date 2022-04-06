package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "lastUpdated", nullable = false)
    private Timestamp lastUpdated;

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Staff> staff;

    @JsonIgnore
    @ManyToOne
    Address address;

}
