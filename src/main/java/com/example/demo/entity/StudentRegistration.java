package com.example.demo.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="student_registration")
public class StudentRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer Id;
	
	@NotNull
	@NotBlank(message="Please enter your name")
	@Size(min=2, max=30,message="Last name should have atleast 2 characters")
    @Column(name = "fullname")
	private String fullName;
	
	@NotNull
	@NotBlank(message="Please enter your username")
	@Size(min=2, max=30,message="Last name should have atleast 2 characters")
    @Column(name = "username")
	private String userName;
	
	@NotNull
	@NotBlank(message="Please enter your email")
    @Email(message = "Email should be valid")
	@Pattern(regexp="[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+")
    @Column(name = "student_email")
	private String studentEmail;
	
	@NotNull
	@NotBlank(message="Please enter parents email")
    @Email(message = "Email should be valid")
	@Pattern(regexp="[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+")
    @Column(name = "parent_email")
	private String parentEmail;
	
	@NotNull
	@NotBlank(message="Please enter parents phone number")
	@Pattern(regexp="([7-9][0-9]{9})")
    @Column(name = "parent_mobile")
	private String parentMobile;
	
	@NotNull
	@NotBlank(message="Please enter password")
    @Column(name = "student_password")
	private String studentPassword;
	
	@Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
   


}
