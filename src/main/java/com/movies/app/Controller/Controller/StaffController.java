package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    //adds a staff
    @PostMapping(value = "/addStaff", consumes = "application/JSON")
    public Staff handleAddStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }

    //gets all staff
    @GetMapping(value = "/staff", produces = "application/JSON")
    public List<Staff> handleGetAllStaffs(){
        return staffService.getAllStaff();
    }

    //gets a staff by its id
    @GetMapping(value = "/staff/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Staff handleGetStaffById(@PathVariable int id){
        return staffService.getStaffById(id);
    }

    //get staff by first name
    @GetMapping(value = "/staff/{firstName}", produces = "application/json")
    public Staff handleGetStaffByFirstName(@PathVariable String firstName){
        return staffService.getStaffByFirstName(firstName);
    }

    //get staff by last name
    @GetMapping(value = "/staff/{lastName}", produces = "application/json")
    public Staff handleGetStaffByLastName(@PathVariable String lastname){
        return staffService.getStaffByLastName(lastname);
    }

    //update staff Rest API
    @PutMapping(value = "/updateStaff/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Staff handleUpdateStaff(int id, Staff staffInfo){
        return staffService.updateStaff(id, staffInfo);
    }

    // delete staff from rest API
    @DeleteMapping(value = "/deleteStaff/{id}")
    public String handleDeleteStaff(@PathVariable int id){
        return staffService.deleteStaff(id);
    }
}
