package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Repository.StaffRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StaffService implements UserDetailsService {
    @Autowired
    private final StaffRepo staffRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff user = staffRepo.findByUsername(username);
        if (user == null) {
            log.error("Staff not found in the database");
            throw new UsernameNotFoundException("Staff not found in the database");
        } else {
            log.info("Staff found in database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
//      user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
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
    public Staff getStaffByUsername(String username){
        return staffRepo.findByUsername(username);
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
        Staff staff=staffRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Staff with id:" + id+" does not exist."));
        staffRepo.delete(staff);
        return "Staff id "+id+" has been deleted!";
    }
}
