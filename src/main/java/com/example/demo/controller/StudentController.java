package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.ForgotPassword;
import com.example.demo.entity.LogOutPayload;
import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.BaseResponse;
import com.example.demo.exception.StudentException;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/api/students")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin("*")
public class StudentController {
	@Autowired(required = false)
	private StudentService studentService;

//http://localhost:8080/api/students/register

	@PostMapping("/register")
	public String registerStudent(@Valid @RequestBody StudentRegistration student) {
		try {
			Integer status = studentService.registerStudent(student);
			if (status == 1) {
				System.out.println("student:" + student.getFullName() + " added to database");
				return "student:" + student.getFullName() + " added to database";
			} else {
				System.out.println("Unable to add student");
				return "Unable to add student to database";
			}
		} catch (StudentException studentException) {
			System.out.println(studentException.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, studentException.getMessage());
		}
	}

	// http://localhost:8080/api/students/{id}
	@GetMapping("/{id}")
	public ResponseEntity<StudentRegistration> getStudentById(@PathVariable Integer id) {
		StudentRegistration student = null;
		try {
			student = studentService.getStudentById(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (StudentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// http://localhost:8080/api/students/allstudent
	@GetMapping("/allstudent")
	public ResponseEntity<List<StudentRegistration>> getAllStudents() {
		List<StudentRegistration> studentList = null;
		try {
			studentList = studentService.getAllStudents();
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		} catch (StudentException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	// http://localhost:8080/api/students/login
	@PostMapping("/login")

	public ResponseEntity<?> loginStudent(@RequestBody StudentRegistration student) {
		String str = studentService.loginStudent(student);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	// http://localhost:8080/api/students/logout
	@PostMapping("/logout")

	public ResponseEntity<?> logoutStudent(@RequestBody LogOutPayload student) {
		String str = studentService.logoutStudent(student);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	// http://localhost:8080/api/students/forgot/{newpassword}
	@PostMapping("/forgot/{newPassword}")

	public ResponseEntity<?> forgotPassword(@RequestBody ForgotPassword student, @PathVariable String newPassword) {
		String str = studentService.forgotPassword(student, newPassword);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}