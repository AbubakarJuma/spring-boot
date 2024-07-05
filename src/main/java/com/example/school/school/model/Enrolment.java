package com.example.school.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EnrolmentId;

    private String EnrolmentStatus;

    @ManyToOne
    @JoinColumn(name = "StudentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name ="ApplicationId")
    private Application application;
}