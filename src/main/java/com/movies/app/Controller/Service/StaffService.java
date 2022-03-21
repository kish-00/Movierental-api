package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private final StaffRepo staffRepo;

    public StaffService(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    //creates a staff
    public Staff addStaff(Staff staff){
        return staffRepo.save(staff);
    }

    //create a list of staff

    //read a list of all the staff
    public List<Staff> getAllStaff(){
        return staffRepo.findAll();
    }

    //reads a staff by its id
    public Staff getStaffById(int id){
        return staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id "+id+" does not exit."));
    }

    //reads a staff by userName
    public Staff getStaffByUserName(String userName){
        return staffRepo.findByUserName(userName);
    }

    //reads a staff by their first name
    public Staff getStaffByFirstName(String firstName) {
        return staffRepo.findByFirstName(firstName);
    }

    //reads a staff by the last name
    public Staff getStaffByLastName(String lastName) {
        return staffRepo.findByLastName(lastName);
    }

    //update staff
    public Staff updateStaff(int id, Staff staffInfo){
        Staff staff=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));

        staff.setPaymentId(staffInfo.getPaymentId());
        staff.setFirstName(staffInfo.getFirstName());
        staff.setLastName(staffInfo.getLastName());
        staff.setEmail(staffInfo.getEmail());
        staff.setUsername(staffInfo.getUsername());
        staff.setPassword(staffInfo.getPassword());
        staff.setLastUpdated(staffInfo.getLastUpdated());
        staff.setPictureUrl(staff.getPictureUrl());

        return staffRepo.save(staff);
    }

    // delete staff from rest API
    public  String deleteStaff(int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));
        staffRepo.delete(film);
        return "Staff id "+id+" has been deleted!";
    }
}
