package com.indatacore.reast_api_indatacore.service;

import com.github.javafaker.Faker;
import com.indatacore.reast_api_indatacore.entity.Student;
import com.indatacore.reast_api_indatacore.enumeration.GenderEnum;
import com.indatacore.reast_api_indatacore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student createRandomStudent() {
        Random random = new Random();
        Faker faker = new Faker(new Locale("nl-NL"));
        Student student = new Student();
        student.setId(0L);
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setGender(random.nextInt(10) % 2 == 0? GenderEnum.MALE : GenderEnum.FEMALE);
        System.out.println(student);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
