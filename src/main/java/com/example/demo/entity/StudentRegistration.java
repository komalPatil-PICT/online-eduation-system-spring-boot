package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentRegistration {
	@Id
	@GeneratedValue
	private Long id;
	
	private Long rollNo;
	private String fullName;
	private String username;
	private String password;
	private String studentEmail;
	private Integer studentClass;
	private String parentEmail;
	private String parentMobileNo;
	private String status;
	
	public StudentRegistration() {
		super();
	}

	public StudentRegistration(Long id, Long rollNo, String fullName, String username, String password,
			String studentEmail, Integer studentClass, String parentEmail, String parentMobileNo, String status) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.studentEmail = studentEmail;
		this.studentClass = studentClass;
		this.parentEmail = parentEmail;
		this.parentMobileNo = parentMobileNo;
		this.status = status;
	}

	public StudentRegistration(Long rollNo, String fullName, String username, String password, String studentEmail,
			Integer studentClass, String parentEmail, String parentMobileNo, String status) {
		super();
		this.rollNo = rollNo;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.studentEmail = studentEmail;
		this.studentClass = studentClass;
		this.parentEmail = parentEmail;
		this.parentMobileNo = parentMobileNo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Integer getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public String getParentMobileNo() {
		return parentMobileNo;
	}

	public void setParentMobileNo(String parentMobileNo) {
		this.parentMobileNo = parentMobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentRegistration [id=" + id + ", rollNo=" + rollNo + ", fullName=" + fullName + ", username="
				+ username + ", password=" + password + ", studentEmail=" + studentEmail + ", studentClass="
				+ studentClass + ", parentEmail=" + parentEmail + ", parentMobileNo=" + parentMobileNo + ", status="
				+ status + "]";
	}
}
