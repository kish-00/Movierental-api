package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import  lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cityId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToOne
    private Country country;

}
