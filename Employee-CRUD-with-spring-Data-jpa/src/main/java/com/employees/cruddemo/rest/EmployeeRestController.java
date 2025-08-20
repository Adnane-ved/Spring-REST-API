package com.employees.cruddemo.rest;

import com.employees.cruddemo.entity.Employee;
import com.employees.cruddemo.exception.EmployeeNotFoundException;
import com.employees.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController{

    private EmployeeService employeeservice;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeservice, ObjectMapper objectMapper) {
        this.employeeservice = employeeservice;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeservice.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee getEmployee(@PathVariable int employeeid){
        if(employeeid <= 0){ // il faut rajouter la condition du nombre d'employée dans la base de donnée
            throw new EmployeeNotFoundException("employee not found");
        }
        return employeeservice.findById(employeeid);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(null);
        return employeeservice.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeservice.save(employee);
    }

    @PatchMapping("/employees/{employeeid}")
    public Employee patchload(@PathVariable int employeeid, @RequestBody Map<String,Object> patchLoad){
        Employee employee = employeeservice.findById((employeeid));
        if(employee == null){
            throw new RuntimeException("employee not found");
        }
        if(patchLoad.containsKey("id")){
            throw new RuntimeException("Employee id should not be in the request body");
        }

        Employee theEmployee = apply(patchLoad,employee);

        return employeeservice.save(theEmployee);
    }

    public Employee apply(Map<String,Object> patchLoad, Employee employee){
        ObjectNode patchLoadJson = objectMapper.convertValue(patchLoad,ObjectNode.class);
        ObjectNode employeeJson = objectMapper.convertValue(employee,ObjectNode.class);
        employeeJson.setAll(patchLoadJson);
        return objectMapper.convertValue(employeeJson,Employee.class);
    }

    @DeleteMapping("/employees/{employeeid}")
    public void deleteEmployee(@PathVariable int employeeid){
        employeeservice.deleteById(employeeid);
    }

}
