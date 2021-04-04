package com.example.demo.service;

import static com.example.demo.exception.AppConstants.Email_Exist;
import static com.example.demo.exception.AppConstants.OPERATION_FAILED;
import static com.example.demo.exception.AppConstants.USER_NOT_FOUND;
import static com.example.demo.exception.AppConstants.WRONG_PASSWORD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ForgotPassword;
import com.example.demo.entity.LogOutPayload;
import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.EmailAlreadyExistException;
import com.example.demo.exception.OperationFailedException;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.exception.StudentException;
import com.example.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepositoryImpl;

	@Override
	public Integer registerStudent(StudentRegistration student) throws StudentException {
		try {

			Optional<StudentRegistration> studentEx = studentRepositoryImpl.findByEmailId(student.getStudentEmail());
			if (!studentEx.isPresent()) {
				studentRepositoryImpl.save(student);
				return 1;
			} else {
				throw new EmailAlreadyExistException(Email_Exist);
			}

		} catch (DataAccessException dataAccessException) {
			throw new StudentException(dataAccessException.getMessage(), dataAccessException);
		} catch (Exception exception) {
			throw new StudentException(exception.getMessage(), exception);
		}
	}

	@Override
	public StudentRegistration getStudentById(Integer id) throws StudentException {
		StudentRegistration student = null;
		try {
			Optional<StudentRegistration> optional = studentRepositoryImpl.findById(id);
			if (optional.isPresent()) {
				student = optional.get();
				return student;
			} else {
				throw new StudentException("Invalid Student Id");
			}
		} catch (DataAccessException e) {
			throw new StudentException(e.getMessage(), e);
		}
	}

	@Override
	public List<StudentRegistration> getAllStudents() throws StudentException {
		List<StudentRegistration> studentList = null;
		try {
			studentList = studentRepositoryImpl.findAll();
			if (studentList.size() != 0) {
				return studentList;
			} else {
				throw new StudentException("No Student in the database");
			}
		} catch (DataAccessException e) {
			throw new StudentException(e.getMessage(), e);
		}
	}

	@Override
	public String loginStudent(StudentRegistration student) {

		String str = null;
		Optional<StudentRegistration> studentObj = studentRepositoryImpl.findByUserName(student.getUserName());
		if (!studentObj.isPresent()) {
			System.out.println(studentObj);
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String pwd = studentObj.get().getStudentPassword();
			if (!pwd.equals(student.getStudentPassword())) {
				throw new ResourceNotFound(WRONG_PASSWORD);
			}
			try {
				str = "Login in sucessfull";
				studentRepositoryImpl.saveAndFlush(studentObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

	@Override
	public String logoutStudent(LogOutPayload student) {
		String str = null;
		Optional<StudentRegistration> studentObj = studentRepositoryImpl.findById(1);
		if (!studentObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			try {
				str = "Sign Out sucessfull";
				studentRepositoryImpl.saveAndFlush(studentObj.get());
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

	@Override
	public String forgotPassword(ForgotPassword student, String newPassword) {
		String str = null;
		Optional<StudentRegistration> userObj = studentRepositoryImpl.findByUserName(student.getUsername());

		if (!userObj.isPresent()) {
			throw new ResourceNotFound(USER_NOT_FOUND);
		} else {
			String studentEmail = userObj.get().getStudentEmail();
			if (!studentEmail.equals(student.getEmail())) {
				throw new ResourceNotFound(USER_NOT_FOUND);
			}
			try {
				userObj.get().setStudentPassword(newPassword);
				studentRepositoryImpl.saveAndFlush(userObj.get());
				str = "Password updated sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException(OPERATION_FAILED);
			}
		}
		return str;
	}

}
