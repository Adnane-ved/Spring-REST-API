package com.employees.cruddemo.dao;

import com.employees.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entitymanager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }

    @Override
    public List<Employee> findAll() {
        return entitymanager.createQuery("From Employee",Employee.class).getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entitymanager.find(Employee.class,id);

        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return entitymanager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        entitymanager.remove(entitymanager.find(Employee.class,id));
    }


}
