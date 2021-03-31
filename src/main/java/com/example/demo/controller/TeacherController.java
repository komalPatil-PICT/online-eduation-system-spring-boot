package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OnlineTest;
import com.example.demo.repository.OnlineTestRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

	@Autowired
	private OnlineTestRepo orepo;

	@PostMapping("/save")
	public void saveMoreProduct(@RequestBody OnlineTest test) {
		orepo.save(test);

	}

}
