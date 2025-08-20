package com.employees.cruddemo.service;

import com.employees.cruddemo.dao.EmployeeDao;
import com.employees.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeedao;

    @Autowired
    public void setEmployeedao(EmployeeDao employeedao) {
        this.employeedao = employeedao;
    }

    @Override
    public List<Employee> findAll() {
        return employeedao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeedao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeedao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeedao.deleteById(id);
    }
}
