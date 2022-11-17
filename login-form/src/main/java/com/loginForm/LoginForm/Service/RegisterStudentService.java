package com.loginForm.LoginForm.Service;

import com.loginForm.LoginForm.Entity.RegisterStudent;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public interface RegisterStudentService {
    RegisterStudent saveRegisterStudent(RegisterStudent registerStudent);
    List<RegisterStudent> getAllRegisterStudent();
    RegisterStudent getRegisterStudentById(long id);
    RegisterStudent updateRegisterStudent(RegisterStudent registerStudent, long id);
    void deleteRegisterStudentById(long id);

}
