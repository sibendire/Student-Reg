package com.loginForm.LoginForm.Service.ServiceImpl;

import com.loginForm.LoginForm.Entity.TeachersDetails;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Repository.TeachersDetailsRepository;
import com.loginForm.LoginForm.Service.TeachersDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeachersDetailsServiceImpl implements TeachersDetailsService {
    private TeachersDetailsRepository teachersDetailsRepository;

    public TeachersDetailsServiceImpl(TeachersDetailsRepository teachersDetailsRepository) {

        this.teachersDetailsRepository = teachersDetailsRepository;
    }

    @Override
    public TeachersDetails saveTeacherDetail(TeachersDetails teachersDetails) {
        return teachersDetailsRepository.save(teachersDetails);
    }

    @Override
    public List<TeachersDetails>getAllTeachersDetails() {
        return teachersDetailsRepository.findAll();
    }

    @Override
    public TeachersDetails getTeachersDetailsById(long id) {
        Optional<TeachersDetails> teachersDetails = teachersDetailsRepository.findById(id);
        if (teachersDetails.isPresent()) {
            return teachersDetails.get();
        } else {
            throw new ResourceNotFoundException(" teachersDetails", "Id", id);
        }

    }

    @Override
    public TeachersDetails updateTeachersDetails(TeachersDetails teachersDetails, long id) {
        TeachersDetails existingTeachersDetails = teachersDetailsRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException(" teachersDetails", "Id", id));
        existingTeachersDetails.setFirstName(teachersDetails.getFirstName());
        existingTeachersDetails.setLastName(teachersDetails.getLastName());
        existingTeachersDetails.setOtherName(teachersDetails.getOtherName());
        existingTeachersDetails.setNIN(teachersDetails.getNIN());
        existingTeachersDetails.setEmail(teachersDetails.getEmail());
        existingTeachersDetails.setPhone(teachersDetails.getPhone());
        existingTeachersDetails.setAddress(teachersDetails.getAddress());
        existingTeachersDetails.setDateOfBirth(teachersDetails.getDateOfBirth());
        existingTeachersDetails.setNationality(teachersDetails.getNationality());
        existingTeachersDetails.setSubjects(teachersDetails.getSubjects());
        existingTeachersDetails.setDepartments(teachersDetails.getDepartments());

        return existingTeachersDetails;

    }


    @Override
    public void deleteTeachersDetailsById(long id) {
        teachersDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TeachersDetails", "Id", id));
        teachersDetailsRepository.deleteById(id);

    }
}
