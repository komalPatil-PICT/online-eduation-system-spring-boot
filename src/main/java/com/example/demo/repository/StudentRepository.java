package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentRegistration;

public interface StudentRepository extends JpaRepository<StudentRegistration, Long>{

}
