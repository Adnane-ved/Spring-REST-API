package com.employees.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler
    public ResponseEntity<EmployeesException> habdleexception(EmployeeNotFoundException exc){
        EmployeesException employeeException = new EmployeesException();
        employeeException.setMessage(exc.getMessage());
        employeeException.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(employeeException,HttpStatus.NOT_FOUND);
    }

}
