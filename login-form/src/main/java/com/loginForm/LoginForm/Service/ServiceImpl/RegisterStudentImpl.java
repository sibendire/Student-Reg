package com.loginForm.LoginForm.Service.ServiceImpl;

import com.loginForm.LoginForm.Entity.RegisterStudent;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Service.RegisterStudentService;
import com.loginForm.LoginForm.Repository.RegisterStudentRepository;

import java.util.List;
import java.util.Optional;


public class RegisterStudentImpl implements RegisterStudentService {
    private RegisterStudentRepository registerStudentRepository;

    public RegisterStudentImpl(RegisterStudentRepository registerStudentRepository) {
        this.registerStudentRepository = registerStudentRepository;
    }

    @Override
    public RegisterStudent saveRegisterStudent(RegisterStudent registerStudent) {
        return registerStudentRepository.save(registerStudent);
    }

    @Override
    public List<RegisterStudent> getAllRegisterStudent() {

        return registerStudentRepository.findAll();
    }

    @Override
    public RegisterStudent getRegisterStudentById(long id) {
        Optional<RegisterStudent> registerStudent=registerStudentRepository.findById(id);
        if (registerStudent.isPresent()){
            return  registerStudent.get();
        }
        else {
            throw new ResourceNotFoundException("registerStudent","Id",id);
        }

    }

    @Override
    public RegisterStudent updateRegisterStudent(RegisterStudent registerStudent, long id) {
        RegisterStudent existingRegisterStudent=registerStudentRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("registerStudent","Id",id));
        existingRegisterStudent.setFirstName(registerStudent.getFirstName());
        existingRegisterStudent.setLastName(registerStudent.getLastName());
        existingRegisterStudent.setOtherName(registerStudent.getOtherName());
        existingRegisterStudent.setDateOfBirth(registerStudent.getDateOfBirth());
        existingRegisterStudent.setGender(registerStudent.getGender());
        existingRegisterStudent.setReligion(registerStudent.getReligion());
        existingRegisterStudent.setHealthStatus(registerStudent.getHealthStatus());
        existingRegisterStudent.setLevel(registerStudent.getLevel());
        existingRegisterStudent.setFormerSchool(registerStudent.getFormerSchool());
        existingRegisterStudent.setPreviousGrade(registerStudent.getPreviousGrade());
        existingRegisterStudent.setNationality(registerStudent.getNationality());
        existingRegisterStudent.setCountry(registerStudent.getCountry());
        existingRegisterStudent.setHomeDistrict(registerStudent.getHomeDistrict());
        existingRegisterStudent.setSubCounty(registerStudent.getSubCounty());
        existingRegisterStudent.setParish(registerStudent.getParish());
        existingRegisterStudent.setVillage(registerStudent.getVillage());

        return existingRegisterStudent;
    }

    @Override
    public void deleteRegisterStudentById(long id) {
        registerStudentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("registerStudent","Id",id));
        registerStudentRepository.deleteById(id);
    }
}
