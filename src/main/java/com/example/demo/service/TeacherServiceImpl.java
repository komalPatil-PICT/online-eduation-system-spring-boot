package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.entity.TeacherRegistrationKomal;
import com.example.demo.exception.SubjectException;
import com.example.demo.exception.TeacherException;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public TeacherRegistrationKomal addTeacher(TeacherRegistrationKomal teach) throws TeacherException {
		TeacherRegistrationKomal teacher = null;
		try {
			teacher = teacherRepository.save(teach);
			return teacher;
		}catch(DataAccessException e) {
			throw new TeacherException(e.getMessage(),e);
		}
	}

	@Override
	public TeacherRegistrationKomal getTeacherById(Long id) throws TeacherException {
		TeacherRegistrationKomal teacher = null;
		try {
			Optional<TeacherRegistrationKomal> optional = teacherRepository.findById(id);
			if (optional.isPresent()) {
				teacher = optional.get();
				return teacher;
			} else {
				throw new TeacherException("Invalid Teacher Id");
			}
		} catch (DataAccessException e) {
			throw new TeacherException(e.getMessage(), e);
		}
	}

	@Override
	public List<TeacherRegistrationKomal> getAllTeachers() throws TeacherException {
		List<TeacherRegistrationKomal> teacherList = null;
		try {
			teacherList = teacherRepository.findAll();
			if (teacherList.size() != 0) {
				return teacherList;
			} else {
				throw new TeacherException("No Teachers in the database");
			}
		} catch (DataAccessException e) {
			throw new TeacherException(e.getMessage(), e);
		}
	}

}
