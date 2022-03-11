package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private int Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToOne
    private Country country;

}
