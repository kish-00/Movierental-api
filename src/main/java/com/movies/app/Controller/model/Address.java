package com.movies.app.Controller.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int addressId;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private int district;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

    @ManyToOne
    private City city;


    @OneToMany(mappedBy = "address1")
    private List<Customer> customers = new ArrayList<Customer>();

    @OneToMany(mappedBy = "address1")
    private List<Staff> staffs = new ArrayList<Staff>();

    @OneToMany(mappedBy = "address1")
    private List<Store> stores = new ArrayList<Store>();

    public int getAddressId() {
        return addressId;
    }

    public void setAddressID(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLast_Update(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }


    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }


    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
