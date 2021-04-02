package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Standard;
import com.example.demo.entity.TeacherRegistrationKomal;
import com.example.demo.exception.StandardException;
import com.example.demo.exception.TeacherException;
import com.example.demo.service.StandardService;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/teacherRegistration")
public class TeacherControllerKomal {
	
	@Autowired
	TeacherService teacherService;
	
	@PostMapping
	public ResponseEntity<TeacherRegistrationKomal> addTeacher(@RequestBody TeacherRegistrationKomal teacher) {
		TeacherRegistrationKomal newTeacher = null;
		try {
			newTeacher = teacherService.addTeacher(teacher);
			return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
		} catch (TeacherException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeacherRegistrationKomal> getTeacherById(@PathVariable Long id) {
		TeacherRegistrationKomal teacher = null;
		try {
			teacher = teacherService.getTeacherById(id);
			return new ResponseEntity<>(teacher, HttpStatus.OK);
		} catch (TeacherException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<List<TeacherRegistrationKomal>> getAllTeachers() {
		List<TeacherRegistrationKomal> teacherList = null;
		try {
			teacherList = teacherService.getAllTeachers();
			return new ResponseEntity<>(teacherList, HttpStatus.OK);
		} catch (TeacherException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
