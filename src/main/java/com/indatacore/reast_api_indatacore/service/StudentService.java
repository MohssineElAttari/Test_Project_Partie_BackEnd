package com.indatacore.reast_api_indatacore.service;

import com.indatacore.reast_api_indatacore.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student createRandomStudent( );
    List<Student> findAllStudents();
}
