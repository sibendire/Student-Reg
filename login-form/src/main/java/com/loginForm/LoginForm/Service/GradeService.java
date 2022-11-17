package com.loginForm.LoginForm.Service;

import com.loginForm.LoginForm.Entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {
    GradeService saveGradeService(GradeService gradeService);
    List<Grade> getAllGrade();
    Grade getGradeById(long id);
    Grade updateById(Grade grade ,long id);
    void deleteGradeById(long id);


}
