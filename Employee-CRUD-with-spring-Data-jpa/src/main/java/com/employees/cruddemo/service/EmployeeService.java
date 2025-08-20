package com.employees.cruddemo.service;

import com.employees.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public Employee save(Employee employee);
    public void deleteById(int id);
}
