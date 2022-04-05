package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.AuthenticationRequest;
import com.movies.app.Controller.Model.AuthenticationResponse;
import com.movies.app.Controller.Model.Staff;
import com.movies.app.Controller.Service.StaffService;
import com.movies.app.Controller.Util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class StaffController {

    @Autowired
    private final StaffService staffService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
        public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            } catch (BadCredentialsException e) {
                throw new BadCredentialsException("Incorrect username or password ", e);
            }
            UserDetails userDetails = staffService.loadUserByUsername(authenticationRequest.getUsername());
            String token = jwtUtil.generationToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(token));
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

    //gets staff by username
    @GetMapping(value = "staff/{userName}")
    public Staff handleGetStaffByUsername(@PathVariable String username){
        return staffService.getStaffByUsername(username);
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
