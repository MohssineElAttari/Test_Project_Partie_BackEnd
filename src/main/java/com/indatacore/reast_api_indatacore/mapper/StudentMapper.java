package com.indatacore.reast_api_indatacore.mapper;

import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
import com.indatacore.reast_api_indatacore.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentMapper{
    Student StudentRequestToStudent(StudentRequest studentRequest);
    StudentResponse StudentToStudentResponse(Student student);
    Student StudentToStudentResponse(StudentRequest studentRequest);
    List<StudentResponse> StudenListToStudentResponseList(Collection<Student> students);
}