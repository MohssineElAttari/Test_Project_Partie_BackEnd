package com.indatacore.reast_api_indatacore.controller;

import com.indatacore.reast_api_indatacore.entity.Student;
import com.indatacore.reast_api_indatacore.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Student")
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController{
    private final StudentService studentService;
    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(studentService.createStudent(student));
    }

    @Override
    public ResponseEntity<Student> createRandomStudent() {
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(studentService.createRandomStudent());
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(studentService.findAllStudents());
    }
}
