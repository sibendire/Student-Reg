package com.loginForm.LoginForm.Service;

import com.loginForm.LoginForm.Entity.TeachersDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeachersDetailsService {
    TeachersDetails saveTeacherDetail(TeachersDetails teachersDetails);
    List<TeachersDetails> getAllTeachersDetails();
    TeachersDetails getTeachersDetailsById(long id);
    TeachersDetails updateTeachersDetails(TeachersDetails teachersDetails, long id);
    void deleteTeachersDetailsById(long id);


}
