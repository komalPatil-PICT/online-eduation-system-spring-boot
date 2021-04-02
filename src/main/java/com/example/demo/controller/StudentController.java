package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.BaseResponse;
import com.example.demo.exception.StudentException;
import com.example.demo.service.StudentService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class StudentController {
	@Autowired(required = false)
    private StudentService studentService;

 
//http://localhost:8080/api/students/register
	
	    @PostMapping("/register")
	    public String registerStudent(@Valid @RequestBody StudentRegistration student) 
	    {
	        try 
	        {
	            Integer status= studentService.registerStudent(student);
	            if(status ==1)
	            {
	                log.info("student:"+student.getFullName()+" added to database");
	                return "student:"+student.getFullName()+" added to database";
	            }
	            else 
	            {
	                log.debug("Unable to add student");
	                return "Unable to add student to database";
	            }
	        }
	        catch(StudentException studentException)
	        {
	            log.error(studentException.getMessage());
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,studentException.getMessage());
	        }
	    }
	    @PostMapping("/login") 
	    
	    public ResponseEntity<?>loginStudent( @RequestBody StudentRegistration student) {
	        String str = studentService.loginStudent(student);
	        BaseResponse baseResponse = new BaseResponse();
	        baseResponse.setStatusCode(1);
	        baseResponse.setResponse(str);
	        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	    }

	 
	    }