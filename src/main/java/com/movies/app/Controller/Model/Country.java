package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<City>();

}
