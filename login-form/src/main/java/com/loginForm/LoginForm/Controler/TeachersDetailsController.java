package com.loginForm.LoginForm.Controler;

import com.loginForm.LoginForm.Entity.TeachersDetails;
import com.loginForm.LoginForm.Repository.TeachersDetailsRepository;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//this is teachers details controller class
@RestController
@RequestMapping

public class TeachersDetailsController {
    private TeachersDetailsRepository teachersDetailsRepository;

    public TeachersDetailsController(TeachersDetailsRepository teachersDetailsRepository) {
        this.teachersDetailsRepository = teachersDetailsRepository;
    }


    @PostMapping("/save")
    public ResponseEntity<TeachersDetails> saveTeachersDetails(@RequestBody TeachersDetails teachersDetails) {
        return new ResponseEntity<TeachersDetails>(teachersDetailsRepository.save
                (teachersDetails), HttpStatus.CREATED);
    }

    //get
    @GetMapping("/all")
    public List<TeachersDetails> getAllTeachersDetails() {
        return teachersDetailsRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TeachersDetails> getTeachersDetailsById(@PathVariable long id) {
        TeachersDetails teachersDetails = teachersDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("teachers details not found id:" + id));
        return ResponseEntity.ok(teachersDetails);
    }

    @PutMapping("{id}")

    public ResponseEntity<TeachersDetails> updateSponsorDetails(@PathVariable long id,
                                                                @RequestBody TeachersDetails teachersDetails) {
        TeachersDetails updateTeachersDetails = teachersDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Student not exist with id:" + id));
        updateTeachersDetails.setFirstName(teachersDetails.getFirstName());
        updateTeachersDetails.setLastName(teachersDetails.getLastName());
        updateTeachersDetails.setOtherName(teachersDetails.getOtherName());
        updateTeachersDetails.setNIN(teachersDetails.getNIN());
        updateTeachersDetails.setDateOfBirth(teachersDetails.getDateOfBirth());
        updateTeachersDetails.setEmail(teachersDetails.getEmail());
        updateTeachersDetails.setPhone(teachersDetails.getPhone());
        updateTeachersDetails.setNationality(teachersDetails.getNationality());
        updateTeachersDetails.setDepartments(teachersDetails.getDepartments());
        teachersDetailsRepository.save(updateTeachersDetails);
        return ResponseEntity.ok(updateTeachersDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletedSponsorDetails(@PathVariable("id") long id) {
        teachersDetailsRepository.deleteById(id);
        return new ResponseEntity<String>("Teachers details deleted successfully", HttpStatus.OK);
    }
}
