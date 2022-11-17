package com.loginForm.LoginForm.Controler;

import com.loginForm.LoginForm.Entity.RegisterStudent;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Repository.RegisterStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//this is student registration controller

@RestController
@RequestMapping("/api/registerStudent")
public class RegisterStudentController {
    private RegisterStudentRepository registerStudentRepository;

    public RegisterStudentController(RegisterStudentRepository registerStudentRepository) {
        this.registerStudentRepository = registerStudentRepository;
    }
    //save

    @PostMapping("/save")
    public ResponseEntity<RegisterStudent> saveRegisterStudent(@RequestBody RegisterStudent registerStudent) {
        return new ResponseEntity<RegisterStudent>(registerStudentRepository.save
                (registerStudent), HttpStatus.CREATED);
    }

    //get
    @GetMapping("/all")
    public List<RegisterStudent> getAllRegisterStudent() {
        return registerStudentRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<RegisterStudent> getRegisterStudentById(@PathVariable long id) {
        RegisterStudent registerStudent = registerStudentRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("student not registered id:" + id));
        return ResponseEntity.ok(registerStudent);
    }

    @PutMapping("{id}")

    public ResponseEntity<RegisterStudent> updateRegisterStudent(@PathVariable long id,
                                                                 @RequestBody RegisterStudent registerStudent) {
        RegisterStudent updateRegisterStudent = registerStudentRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Student not exist with id:" + id));
        updateRegisterStudent.setFirstName(registerStudent.getFirstName());
        updateRegisterStudent.setLastName(registerStudent.getLastName());
        updateRegisterStudent.setOtherName(registerStudent.getOtherName());
        updateRegisterStudent.setDateOfBirth(registerStudent.getDateOfBirth());
        updateRegisterStudent.setGender(registerStudent.getGender());
        updateRegisterStudent.setReligion(registerStudent.getReligion());
        updateRegisterStudent.setHealthStatus(registerStudent.getHealthStatus());
        updateRegisterStudent.setLevel(registerStudent.getLevel());
        updateRegisterStudent.setFormerSchool(registerStudent.getFormerSchool());
        updateRegisterStudent.setPreviousGrade(registerStudent.getPreviousGrade());
        updateRegisterStudent.setNationality(registerStudent.getNationality());
        updateRegisterStudent.setCountry(registerStudent.getCountry());
        updateRegisterStudent.setHomeDistrict(registerStudent.getHomeDistrict());
        updateRegisterStudent.setSubCounty(registerStudent.getSubCounty());
        updateRegisterStudent.setParish(registerStudent.getVillage());
        registerStudentRepository.save(updateRegisterStudent);
        return ResponseEntity.ok(updateRegisterStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletedRegisterStudent(@PathVariable("id") long id) {
        registerStudentRepository.deleteById(id);
        return new ResponseEntity<String>("student deleted successfully", HttpStatus.OK);
    }
    }
