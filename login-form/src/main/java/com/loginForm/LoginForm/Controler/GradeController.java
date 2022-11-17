package com.loginForm.LoginForm.Controler;

import com.loginForm.LoginForm.Entity.Grade;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Repository.GradeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//this is grade controller class for subjects

@RestController
@RequestMapping()
public class GradeController {
    private GradeRepository gradeRepository;

    @PostMapping("/grades")
    public ResponseEntity<Grade>savaGrades(@RequestBody Grade grade){
        return new ResponseEntity<Grade>(gradeRepository.save(grade), HttpStatus.CREATED);
    }
    @GetMapping("/al")
    public List<Grade>getAllGrade(){
        return gradeRepository.findAll();
    }
    @GetMapping("{id1}")
    public ResponseEntity<Grade>getGradeById(@PathVariable long id){
        Grade grade = gradeRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("Grade not found by id:"+id));
                return ResponseEntity.ok(grade);
    }
    @PutMapping("{id1}")
    public ResponseEntity<Grade>updateGrade(@PathVariable long id,@RequestBody Grade grade){
        Grade updateGrade = gradeRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("grade not found by id:"+id));
        updateGrade.setLiterature(grade.getLiterature());
        updateGrade.setKiswahili(grade.getKiswahili());
        updateGrade.setBuilding(grade.getBuilding());
        updateGrade.setAgriculture(grade.getAgriculture());
        updateGrade.setFrench(grade.getFrench());
        updateGrade.setFineArt(grade.getFineArt());
        updateGrade.setCre(grade.getCre());
        updateGrade.setComputer(grade.getComputer());
        updateGrade.setHistory(grade.getHistory());
        updateGrade.setCommerce(grade.getCommerce());
        updateGrade.setGeography(grade.getGeography());
        updateGrade.setMathematics(grade.getMathematics());
        updateGrade.setPhysics(grade.getPhysics());
        updateGrade.setBiology(grade.getBiology());
        updateGrade.setChemistry(grade.getChemistry());
        updateGrade.setEnglish(grade.getEnglish());
        updateGrade.setEntrepreneurship(grade.getEntrepreneurship());
        return ResponseEntity.ok(updateGrade);
    }
    @DeleteMapping("{id1}")
    public ResponseEntity<String> deleteGrade(@PathVariable ("id")long id){
        gradeRepository.deleteById(id);
        return new ResponseEntity<String>("grade deleted successfully",HttpStatus.OK);
    }
}
