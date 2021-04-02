package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.enums.Subjects;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sub_id")
	private Long subId;
	
	@Column(name="sub_name")
    @Enumerated(EnumType.STRING)
	private Subjects subName;


	@JsonIgnore
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<StandardSubjects> standardSubjects = new HashSet<StandardSubjects>();
	
	public Subject() {
	
	}

	public Subject(Long subId, Subjects subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}

	public Set<StandardSubjects> getStandardSubjects() {
		return standardSubjects;
	}

	public void setStandardSubjects(Set<StandardSubjects> standardSubjects) {
		this.standardSubjects = standardSubjects;
	}

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public Subjects getSubName() {
		return subName;
	}

	public void setSubName(Subjects subName) {
		this.subName = subName;
	}
	
	
}
