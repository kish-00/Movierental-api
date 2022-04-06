package com.movies.app.Controller.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int addressId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district", nullable = false)
    private int district;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "lastUpdate", nullable = false)
    private Timestamp lastUpdate;

    @JsonIgnore
    @ManyToOne
    private City city;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Customer> customers = new ArrayList<Customer>();

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Staff> staffs = new ArrayList<Staff>();

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Store> stores = new ArrayList<Store>();
}
