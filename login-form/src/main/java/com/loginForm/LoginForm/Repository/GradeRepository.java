package com.loginForm.LoginForm.Repository;

import com.loginForm.LoginForm.Entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
