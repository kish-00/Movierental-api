package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Staff> getStaffById(int id){
        Staff staff=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id "+id+" does not exit."));
        return ResponseEntity.ok(staff);
    }

    //update staff
    public ResponseEntity<Staff> updateFilms(int id, Staff staffInfo){
        Staff staff=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));

        staff.setPaymentId(staffInfo.getPaymentId());
        staff.setFirstName(staffInfo.getFirstName());
        staff.setLastName(staffInfo.getLastName());
        staff.setEmail(staffInfo.getEmail());
        staff.setUsername(staffInfo.getUsername());
        staff.setPassword(staffInfo.getPassword());
        staff.setLastUpdated(staffInfo.getLastUpdated());
        staff.setPictureUrl(staff.getPictureUrl());

        staffRepo.save(staff);
        return ResponseEntity.ok(staff);
    }

    // delete staff from rest API
    public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Staff film=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));
        staffRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
