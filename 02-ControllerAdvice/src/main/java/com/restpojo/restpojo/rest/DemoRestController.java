package com.restpojo.restpojo.rest;

import com.restpojo.restpojo.Student;
import com.restpojo.restpojo.exception.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class DemoRestController {

    private List<Student> students;

    @PostConstruct // we do it once, we don't have to put it in get request
    public void loadStudents(){
        students = new ArrayList<>();
        students.add(new Student("Adnane","Rafai",1));
        students.add(new Student("Dinh","Mai",2));
    }

    @GetMapping("/")
    public List<Student> getStudent() {

        return students;
    }

    @GetMapping("/{studentid}")
    public Student getStudent(@PathVariable int studentid){
         if(studentid < 0 || studentid >= students.size()){
           throw new StudentNotFoundException("student doesn't exist "+ studentid);
         }
        return students.get(studentid);
    }



}
