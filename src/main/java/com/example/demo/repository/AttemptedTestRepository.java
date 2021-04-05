package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AttemptedTest;

public interface AttemptedTestRepository extends JpaRepository<AttemptedTest, Integer> {

}
