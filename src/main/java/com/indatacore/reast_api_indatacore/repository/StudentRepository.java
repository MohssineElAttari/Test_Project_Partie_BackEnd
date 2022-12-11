package com.indatacore.reast_api_indatacore.repository;

import com.indatacore.reast_api_indatacore.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
