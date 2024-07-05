package com.example.school.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.school.model.Student;
import com.example.school.school.service.StudentService;

@RestController
@RequestMapping("/studentData")
public class StudentController {

    @GetMapping
    public ResponseEntity<Student> getStudentData(@RequestParam String userName) {
        // Fetch student data from the database using the userName
        Student user = StudentService.getUserByUserName(userName);
        return ResponseEntity.ok(user);
    }
}
