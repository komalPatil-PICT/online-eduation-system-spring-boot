package com.example.demo.service;

import static com.example.demo.exception.AppConstants.OPERATION_FAILED;
import static com.example.demo.exception.AppConstants.USER_NOT_FOUND;
import static com.example.demo.exception.AppConstants.WRONG_PASSWORD;
import static com.example.demo.exception.AppConstants.Email_Exist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.exception.OperationFailedException;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.EmailAlreadyExistException;
import com.example.demo.exception.StudentException;
import com.example.demo.repository.StudentRepository;



@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepositoryImpl;
	
	@Override
	public Integer registerStudent(StudentRegistration student) throws StudentException {
		try {
			
			Optional<StudentRegistration> studentEx=studentRepositoryImpl.findByEmailId(student.getStudentEmail());
            if(!studentEx.isPresent())
            {
            	studentRepositoryImpl.save(student);
                return 1;
            }
            else
            {
                throw new EmailAlreadyExistException(Email_Exist);
            }
			
			
		}catch(DataAccessException dataAccessException) {
			throw new StudentException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new StudentException(exception.getMessage(),exception);
		}
	}

	@Override
	public String loginStudent(StudentRegistration student) {
		
			String str=null;
			Optional<StudentRegistration> studentObj= studentRepositoryImpl.findByUserName(student.getUserName());
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
	}

	
	

