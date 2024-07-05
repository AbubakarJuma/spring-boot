package com.example.school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.school.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}

