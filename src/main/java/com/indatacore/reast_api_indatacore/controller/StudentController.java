package com.indatacore.reast_api_indatacore.controller;

import com.indatacore.reast_api_indatacore.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {
    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student student);
    @PostMapping("/random")
    ResponseEntity<Student> createRandomStudent();
    @GetMapping
    ResponseEntity<List<Student>> getAllStudents();
}
