package com.geekster.University.Event.Management.System.repository;

import com.geekster.University.Event.Management.System.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer> {
}
