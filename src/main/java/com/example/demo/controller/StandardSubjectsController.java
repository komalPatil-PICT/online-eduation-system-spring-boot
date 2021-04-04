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

import com.example.demo.entity.StandardSubjectDO;
import com.example.demo.entity.StandardSubjects;
import com.example.demo.entity.Subject;
import com.example.demo.exception.StandardSubjectException;
import com.example.demo.exception.SubjectException;
import com.example.demo.service.StandardSubjectsService;

@RestController
@RequestMapping("/higherAuthority/standardSubjects")
public class StandardSubjectsController {

	@Autowired
	StandardSubjectsService stdSubService;

	@PostMapping()
	public String assignSubjectsToStandard(@RequestBody StandardSubjectDO stdSubDO) {

		try {
			StandardSubjects status;
			status = stdSubService.assignSubjectsToStandard(stdSubDO);

			if (status != null) {
				return "Subject ID: " + stdSubDO.getSub_id() + " is assigned to std ID: " + stdSubDO.getStd_id();
			} else {
				return "Unable to assign subject to standard";
			}
		} catch (StandardSubjectException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
	
	@GetMapping
	public ResponseEntity<List<StandardSubjects>> getAllRows() {
		List<StandardSubjects> subList = null;
		try {
			subList = stdSubService.getAllRows();
			return new ResponseEntity<>(subList, HttpStatus.OK);
		} catch (StandardSubjectException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	//localhost:8080/higherAuthority/standardSubjects/teacher/2
		@GetMapping("/teacher/{id}")
		public ResponseEntity<List<StandardSubjects>> getAllRowsByTeacherId(@PathVariable Long id) {
			List<StandardSubjects> subList = null;
			try {
				subList = stdSubService.findAllByTeacherId(id);
				return new ResponseEntity<>(subList, HttpStatus.OK);
			} catch (StandardSubjectException e) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			}
		}
}
