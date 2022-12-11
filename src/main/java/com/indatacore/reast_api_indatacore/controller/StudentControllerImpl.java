package com.indatacore.reast_api_indatacore.controller;

import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
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
    //--------------------------- Add Students : ---------------------------
    @Override
    public ResponseEntity<StudentResponse> createStudent(StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(studentRequest));
    }
    //--------------------------- Add Random Students : ---------------------------
    @Override
    public ResponseEntity<StudentResponse> createRandomStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.createRandomStudent());
    }
    //--------------------------- All Students : ---------------------------
    @Override
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudents());
    }
}
