package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Schedule {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
	private String subject ;
	private Long teacher_id;
	private String teacher_name;
	private String teacherEmail;
	private String lectureLink;
	private String timing;
	
	public Schedule() {
		super();
	}

	public Schedule(String subject, Long teacher_id, String teacher_name, String teacherEmail, String lectureLink,
			String timing) {
		super();
		this.subject = subject;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacherEmail = teacherEmail;
		this.lectureLink = lectureLink;
		this.timing = timing;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getLectureLink() {
		return lectureLink;
	}

	public void setLectureLink(String lectureLink) {
		this.lectureLink = lectureLink;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	@Override
	public String toString() {
		return "Schedule [subject=" + subject + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name
				+ ", teacherEmail=" + teacherEmail + ", lectureLink=" + lectureLink + ", timing=" + timing + "]";
	}
}
