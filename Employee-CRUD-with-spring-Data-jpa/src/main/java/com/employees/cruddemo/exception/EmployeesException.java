package com.employees.cruddemo.exception;

import com.employees.cruddemo.entity.Employee;

public class EmployeesException {
    private String message;
    private int statusCode;

    public EmployeesException() {}

    public EmployeesException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
