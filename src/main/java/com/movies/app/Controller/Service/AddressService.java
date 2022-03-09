package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Address;
import com.movies.app.Controller.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    //creates an address
    public Address addAddress(Address address){
        return addressRepo.save(address);
    }

    //create a list of addresses

    //read a list of all the addresses
    public List<Address> getAllAddresses(){
        return addressRepo.findAll();
    }

    //reads an address by its id
    public ResponseEntity<Address> getAddressById(int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id "+id+" does not exit."));
        return ResponseEntity.ok(address);
    }

    //update address Rest API
    public ResponseEntity<Address> updateAddress(int id, Address addressInfo){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id "+id+" does not exist."));

        address.setAddress(addressInfo.getAddress());
        address.setAddress2(addressInfo.getAddress2());
        address.setDistrict(addressInfo.getDistrict());
        address.setPostalCode(addressInfo.getPostalCode());
        address.setPhone(addressInfo.getPhone());
        address.setLastUpdate(addressInfo.getLastUpdate());

        addressRepo.save(address);
        return ResponseEntity.ok(address);
    }

    // delete address from rest API
    public  ResponseEntity<HttpStatus> deleteActor(int id) {
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id: "+id+" does not exist."));
        addressRepo.delete(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}