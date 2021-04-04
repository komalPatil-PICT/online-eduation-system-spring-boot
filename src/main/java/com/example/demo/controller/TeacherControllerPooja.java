package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TimeTable;
import com.example.demo.repository.TimeTableRepository;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class TeacherControllerPooja {
	
		
		@Autowired
		private TimeTableRepository trepo;

		@PostMapping("/save/timetable")
		public void saveTimeTable(@RequestBody TimeTable timetable) {
			trepo.save(timetable);

		}


	}


