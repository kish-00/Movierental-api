package com.movies.app.Controller.Controller;

//import java.net.URI;

import com.movies.app.Controller.Repository.AddressRepo;
import com.movies.app.Controller.Model.Address;
import com.movies.app.Controller.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    // get all addresses
    @GetMapping(value = "/address", produces = "application/JSON")
    public List<Address> getAllActors(){
        return addressRepo.findAll();
    }

    //create address
    @PostMapping(value = "/address", consumes = "application/JSON")
    public Address createAddress(@RequestBody Address address){
        return addressRepo.save(address);
    }

    //get address by id
    @GetMapping(value = "/address/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Address> getActorById(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id: "+id+" does not exist."));
        return ResponseEntity.ok(address);
    }

    // update address
    @PutMapping(value = "/address/{id}", consumes = "application/JSON", produces = "application/JSON")
    public ResponseEntity<Address> updateActor(@PathVariable int id,@RequestBody Address addressInfo){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id: "+id+" does not exist."));

        address.setAddress(addressInfo.getAddress());
        address.setAddress2(addressInfo.getAddress2());
        address.setDistrict(addressInfo.getDistrict());
        address.setPostalCode(addressInfo.getPostalCode());
        address.setPhone(addressInfo.getPhone());
        address.setLastUpdate(addressInfo.getLastUpdate());

        addressRepo.save(address);
        return ResponseEntity.ok(address);
    }

    // delete address
    @DeleteMapping(value = "/address/{id}")
    public  ResponseEntity<HttpStatus> deleteActor(@PathVariable int id){
        Address address=addressRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Address with id: "+id+" does not exist."));
        addressRepo.delete(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
