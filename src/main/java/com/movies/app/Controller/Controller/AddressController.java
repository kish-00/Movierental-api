package com.movies.app.Controller.Controller;


import com.movies.app.Controller.Repository.AddressRepo;
//import com.movies.app.Controller.Repository.CountryRepo;
import com.movies.app.Controller.exception.ResourceNotFoundException;
import com.movies.app.Controller.model.Address;
//import com.movies.app.Controller.model.Address;
//import com.movies.app.Controller.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class AddressController {


    @Autowired
    private AddressRepo addressRepo;


    // get all addresses
    @GetMapping(value = "/address")
    public List<Address> getAllActors(){
        return addressRepo.findAll();
    }
    //create address Rest API
    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address){
        return addressRepo.save(address);

    }
    //get address by id
    @GetMapping(value = "/address/{id}")
    public ResponseEntity<Address> getActorById(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));
        return ResponseEntity.ok(address);
    }

    // update address Rest API
    @PutMapping(value = "/address/{id}")
    public ResponseEntity<Address> updateActor(@PathVariable int id,@RequestBody Address addressDetails){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));

        addressDetails.setAddress(address.getAddress());
        address.setAddress2(address.getAddress2());
        address.setDistrict(address.getDistrict());
        address.setPostalCode(address.getPostalCode());
        address.setPhone(address.getPhone());
        address.setLastUpdate(address.getLastUpdate());

        addressRepo.save(addressDetails);
        return ResponseEntity.ok(address);
    }

    // delete address from rest API
    @DeleteMapping(value = "/address/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address not exist with id:" + id));
        addressRepo.delete(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
