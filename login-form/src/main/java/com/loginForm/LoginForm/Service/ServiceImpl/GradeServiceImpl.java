package com.loginForm.LoginForm.Service.ServiceImpl;

import com.loginForm.LoginForm.Entity.Grade;
import com.loginForm.LoginForm.Exception.ResourceNotFoundException;
import com.loginForm.LoginForm.Repository.GradeRepository;
import com.loginForm.LoginForm.Service.GradeService;

import java.util.List;
import java.util.Optional;

public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;

    public GradeServiceImpl(Grade grade) {
        this.gradeRepository = gradeRepository;
    }


    public Grade saveGradeService(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public GradeService saveGradeService(GradeService gradeService) {
        return null;
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getGradeById(long id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        if (grade.isPresent()){
            return grade.get();
        }
        else {
            throw new ResourceNotFoundException("grade not found ","id",id);
        }
    }

    @Override
    public Grade updateById(Grade grade, long id) {
        Grade existingGrade = gradeRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("grade","Id", id));
        existingGrade.setEnglish(grade.getEnglish());
        existingGrade.setBiology(grade.getBiology());
        existingGrade.setChemistry(grade.getChemistry());
        existingGrade.setPhysics(grade.getPhysics());
        existingGrade.setMathematics(grade.getMathematics());
        existingGrade.setGeography(grade.getGeography());
        existingGrade.setHistory(grade.getHistory());
        existingGrade.setCommerce(grade.getCommerce());
        existingGrade.setComputer(grade.getComputer());
        existingGrade.setCre(grade.getCre());
        existingGrade.setFrench(grade.getFrench());
        existingGrade.setFineArt(grade.getFineArt());
        existingGrade.setAgriculture(grade.getAgriculture());
        existingGrade.setBuilding(grade.getBuilding());
        existingGrade.setKiswahili(grade.getKiswahili());
        existingGrade.setLiterature(grade.getLiterature());
        return existingGrade;
    }

    @Override
    public void deleteGradeById(long id) {
        gradeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("grade","ID",id));
        gradeRepository.deleteById(id);
    }


}

