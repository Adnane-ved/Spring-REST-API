package com.employees.cruddemo.dao;

import com.employees.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public Employee save(Employee employee);
    public void deleteById(int id);

}
