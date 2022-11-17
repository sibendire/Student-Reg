package com.loginForm.LoginForm.Controler;

import com.loginForm.LoginForm.Repository.SponsorDetailsRepository;
import com.loginForm.LoginForm.Entity.SponsorDetails;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//this is sponsor details controller class
@RestController
@RequestMapping


public class SponsorDetailsController {
    private SponsorDetailsRepository sponsorDetailsRepository;


    @PostMapping("/save")
    public ResponseEntity<SponsorDetails> saveSponsorDetails(@RequestBody SponsorDetails sponsorDetails) {
        return new ResponseEntity<SponsorDetails>(sponsorDetailsRepository.save
                (sponsorDetails), HttpStatus.CREATED);
    }

    //get
    @GetMapping("/all")
    public List<SponsorDetails> getAllSponsorDetails() {
        return sponsorDetailsRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<SponsorDetails> getSponsorDetailstById(@PathVariable long id) {
        SponsorDetails sponsorDetails = sponsorDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("student not registered id:" + id));
        return ResponseEntity.ok(sponsorDetails);
    }

    @PutMapping("{id}")

    public ResponseEntity<SponsorDetails> updateSponsorDetails(@PathVariable long id,
                                                               @RequestBody SponsorDetails sponsorDetails) {
        SponsorDetails updateSponsorDetails = sponsorDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Student not exist with id:" + id));
        updateSponsorDetails.setFirstName(sponsorDetails.getFirstName());
        updateSponsorDetails.setLastName(sponsorDetails.getLastName());
        updateSponsorDetails.setNIN(sponsorDetails.getNIN());
        updateSponsorDetails.setEmail(sponsorDetails.getEmail());
        updateSponsorDetails.setPhone(sponsorDetails.getPhone());
        updateSponsorDetails.setOccupation(sponsorDetails.getOccupation());
        updateSponsorDetails.setAddress(sponsorDetails.getAddress());

        sponsorDetailsRepository.save(updateSponsorDetails);
        return ResponseEntity.ok(updateSponsorDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletedSponsorDetails(@PathVariable("id") long id) {
        sponsorDetailsRepository.deleteById(id);
        return new ResponseEntity<String>("student deleted successfully", HttpStatus.OK);
    }
}