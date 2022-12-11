package com.indatacore.reast_api_indatacore.controller;

import com.indatacore.reast_api_indatacore.dto.StudentRequest;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("student/")
@Validated
public interface StudentController {
    @PostMapping
    ResponseEntity<StudentResponse> createStudent(@RequestBody @Validated StudentRequest studentRequest);
    @PostMapping("/random")
    ResponseEntity<StudentResponse> createRandomStudent();
    @GetMapping
    ResponseEntity<List<StudentResponse>> getAllStudents();
}
