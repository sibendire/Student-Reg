package com.loginForm.LoginForm.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static long serialVersionUId=1l;
    private  String resourceName;
    private String fieldName;
    private  Object fieldValue;

    public ResourceNotFoundException(String s, String resourceName, String fieldName, String fieldValue) {
        super (String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


    public ResourceNotFoundException(String registerStudent, String id, long id1) {
    }

    public ResourceNotFoundException(String s) {
    }
}

