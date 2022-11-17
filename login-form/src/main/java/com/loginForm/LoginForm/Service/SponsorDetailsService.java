package com.loginForm.LoginForm.Service;

import com.loginForm.LoginForm.Entity.SponsorDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface SponsorDetailsService {
    SponsorDetails saveSponsorDetails(SponsorDetails sponsorDetails);
    List< SponsorDetails> getAllSponsorDetails();
    SponsorDetails getSponsorDetailsById(long id);
    SponsorDetails updateSponsorDetails (SponsorDetails sponsorDetails, long id);
    void deleteSponsorDetailsById(long id);
}
