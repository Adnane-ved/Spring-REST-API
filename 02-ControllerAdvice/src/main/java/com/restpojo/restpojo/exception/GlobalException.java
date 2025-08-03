package com.restpojo.restpojo.exception;

import com.restpojo.restpojo.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    // ResponseEntity<StudentErrorResponse> represents the entire HTTP response including
    // err as the body
    // HttpStatus.NOT_FOUND as the status code
    // headers optional but we can add it
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
        StudentErrorResponse err = new StudentErrorResponse();
        err.setMessage(ex.getMessage());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse err = new StudentErrorResponse();
        err.setMessage(ex.getMessage());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }


}
