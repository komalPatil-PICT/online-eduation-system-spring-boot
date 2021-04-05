package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.AttemptedTest;
import com.example.demo.entity.OnlineTest;
import com.example.demo.entity.Timetable;
import com.example.demo.services.StudentServices;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/student")
public class StudentController
{
	@Autowired
	StudentServices studentService;
	
	@GetMapping("/timetable/{std}")
	public Timetable getTimeTable(@PathVariable("std") Integer std)
	{
		return studentService.getTimetable(std);
	}
	
	@GetMapping("/onlinetest/{test_id}")
	public OnlineTest getOnlineTest(@PathVariable("test_id") Long test_id)
	{
		return studentService.getOnlineTestById(test_id);
	}
	
	@PostMapping("/attempttest")
	public ResponseEntity<AttemptedTest> attemptTest(@RequestBody AttemptedTest attemptedTest)
	{
		return new ResponseEntity<AttemptedTest>(studentService.addAttemptedTest(attemptedTest),HttpStatus.CREATED);
	}
	
	@GetMapping("/testhistory")
	public List<AttemptedTest> getTestHistory()
	{
		return studentService.getAttemptedTest();
	}
}
