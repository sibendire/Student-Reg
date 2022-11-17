package com.loginForm.LoginForm.Service.ServiceImpl;

import com.loginForm.LoginForm.Entity.SponsorDetails;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Repository.SponsorDetailsRepository;
import com.loginForm.LoginForm.Service.SponsorDetailsService;

import java.util.List;
import java.util.Optional;

public class SponsorDetailsServiceImpl implements SponsorDetailsService {

    private SponsorDetailsRepository sponsorDetailsRepository;

    public SponsorDetailsServiceImpl(SponsorDetailsRepository sponsorDetailsRepository) {
        this.sponsorDetailsRepository = sponsorDetailsRepository;
    }

    @Override
    public SponsorDetails saveSponsorDetails(SponsorDetails sponsorDetails) {
        return sponsorDetailsRepository.save(sponsorDetails);
    }

    @Override
    public List<SponsorDetails> getAllSponsorDetails() {
        return sponsorDetailsRepository.findAll();
    }

    @Override
    public SponsorDetails getSponsorDetailsById(long id) {
        Optional<SponsorDetails>sponsorDetails = sponsorDetailsRepository.findById(id);
        if (sponsorDetails.isPresent()) {
            return sponsorDetails.get();
        } else {
            throw new ResourceNotFoundException("sponsorDetails", "Id", id);
        }

    }

    @Override
    public SponsorDetails updateSponsorDetails(SponsorDetails sponsorDetails, long id) {
        SponsorDetails existingSponsorDetails = sponsorDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("sponsorDetails", "Id", id));
        existingSponsorDetails.setFirstName(sponsorDetails.getFirstName());
        existingSponsorDetails.setLastName(sponsorDetails.getLastName());
        existingSponsorDetails.setNIN(sponsorDetails.getNIN());
        existingSponsorDetails.setEmail(sponsorDetails.getEmail());
        existingSponsorDetails.setPhone(sponsorDetails.getPhone());
        existingSponsorDetails.setOccupation(sponsorDetails.getOccupation());
        existingSponsorDetails.setAddress(sponsorDetails.getAddress());
        return existingSponsorDetails;
    }


    @Override
    public void deleteSponsorDetailsById(long id) {
        sponsorDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("sponsorDetails", "Id", id));
        sponsorDetailsRepository.deleteById(id);

    }
}