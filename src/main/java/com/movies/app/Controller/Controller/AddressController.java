package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Address;
import com.movies.app.Controller.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    //create address
    @PostMapping(value = "/addAddress")
    public Address handleCreateAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    // get all addresses
    @GetMapping(value = "/getAddresses")
    public List<Address> handleGetAllAddresses(){
        return addressService.getAllAddresses();
    }

    //get address by id
    @GetMapping(value = "/getAddress/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Address handleGetAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    //get address by address
    @GetMapping(value = "/getAddress/{address}", produces = "application/json")
    public Address handleGetAddressByAddress(@PathVariable String address){
        return addressService.getAddressByAddress(address);
    }

    // update address
    @PutMapping(value = "/updateAddress/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Address handleUpdateAddress(@PathVariable int id,@RequestBody Address addressInfo){
       return addressService.updateAddress(id, addressInfo);
    }

    // delete address
    @DeleteMapping(value = "/deleteAddress/{id}")
    public  String handleDeleteAddress(@PathVariable int id){
        return addressService.deleteAddress(id);
    }
}
