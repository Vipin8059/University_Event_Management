package com.geekster.University.Event.Management.System.service;

import com.geekster.University.Event.Management.System.model.Department;
import com.geekster.University.Event.Management.System.model.Student;
import com.geekster.University.Event.Management.System.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    public String addStudent(Student student) {
        if(student.getStudentId().equals(studentRepo.findById(student.getStudentId()))){
            studentRepo.save(student);
            return "student updated successfully";
        }
        else{
            studentRepo.save(student);
            return" student added successfully";
        }

    }

    public String updateStudentById(Integer id, Department department) {
            Optional<Student> studentOptional = studentRepo.findById(id);
            Student student = studentOptional.get();
            if(student==null){
                return "student id is not present";
            }
            student.setDepartment(department);
            studentRepo.save(student);
            return "student is updated successfully for id "+id;

    }

    public String deleteStudentById(Integer id) {
         studentRepo.deleteById(id);
         return "Student deleted successfully for id"+id;
    }
}
