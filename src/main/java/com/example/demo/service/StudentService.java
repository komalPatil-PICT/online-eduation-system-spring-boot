package com.example.demo.service;




import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.StudentException;

public interface StudentService {

	public Integer registerStudent( StudentRegistration student) throws StudentException;
	public String loginStudent(StudentRegistration student);
}
