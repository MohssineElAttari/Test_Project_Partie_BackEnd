package com.indatacore.reast_api_indatacore.service;

import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAndSaveStudentsFromCsv();

    StudentResponse createStudent(StudentRequest student);

    StudentResponse createRandomStudent();

    List<StudentResponse> findAllStudents();
}
