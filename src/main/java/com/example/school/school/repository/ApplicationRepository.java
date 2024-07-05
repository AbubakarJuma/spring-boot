package com.example.school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.school.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
