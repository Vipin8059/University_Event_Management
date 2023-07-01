package com.geekster.University.Event.Management.System.controller;

import com.geekster.University.Event.Management.System.model.Department;
import com.geekster.University.Event.Management.System.model.Student;
import com.geekster.University.Event.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

    // get all the students
    @GetMapping("students")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // get student by id
    @GetMapping("student/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    // Add a specific student
    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    //update student department by id
    @PutMapping("student/{id}/{department}")
    public String updateStudentById(@PathVariable Integer id, @PathVariable Department department){
        return studentService.updateStudentById(id,department);
    }

    // delete a student
    @DeleteMapping("student/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }



}
