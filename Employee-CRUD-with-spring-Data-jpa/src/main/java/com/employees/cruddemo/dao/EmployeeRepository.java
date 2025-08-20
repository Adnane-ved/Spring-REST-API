package com.employees.cruddemo.dao;

import com.employees.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // rien à mettre ici
}
