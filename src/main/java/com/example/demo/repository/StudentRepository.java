package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentRegistration;


@Repository
public interface StudentRepository extends JpaRepository<StudentRegistration,Integer>
{
	@Query("select cm from StudentRegistration cm where cm.userName=?1")
	//Optional<StudentRegistration> findByEmailId(String email);
	Optional<StudentRegistration> findByUserName(String userName);

	@Query("select e from StudentRegistration e where e.studentEmail=?1")
	Optional<StudentRegistration> findByEmailId(String studentEmail);
}

