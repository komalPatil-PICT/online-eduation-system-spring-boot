package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.ForgotPassword;
import com.example.demo.entity.LogOutPayload;
import com.example.demo.entity.StudentRegistration;
import com.example.demo.exception.StudentException;


public interface StudentService 
{

	public Integer registerStudent( StudentRegistration student) throws StudentException;
	public StudentRegistration getStudentById(Integer id)throws StudentException;
	public List<StudentRegistration> getAllStudents()throws StudentException;
	public String loginStudent(StudentRegistration student);
	public String logoutStudent(LogOutPayload student);
	 public String forgotPassword(ForgotPassword student, String new_password);
	
	
}
