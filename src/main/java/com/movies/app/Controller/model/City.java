package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<Address>();

    @ManyToOne
    private Country country1;

    public int getCityId() {
        return cityId;
    }

    public void setCityID(int cityId) {
        this.cityId = cityId;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
