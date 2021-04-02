package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


public class ScheduleLecture {
	
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonIgnoreProperties(ignoreUnknown = true)
		@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
		float time;
	    String LectureLink;
	    String subject;
	    String teacherName;
        String teacherMail;
        
        public ScheduleLecture(float time, String lectureLink, String subject, String teacherName, String teacherMail) {
    		super();
    		this.time = time;
    		LectureLink = lectureLink;
    		this.subject = subject;
    		this.teacherName = teacherName;
    		this.teacherMail = teacherMail;
    	}
        
        
        public float getTime() {
    		return time;
    	}

    	public void setTime(float time) {
    		this.time = time;
    	}

    	public String getLectureLink() {
    		return LectureLink;
    	}

    	public void setLectureLink(String lectureLink) {
    		LectureLink = lectureLink;
    	}

    	public String getSubject() {
    		return subject;
    	}

    	public void setSubject(String subject) {
    		this.subject = subject;
    	}

    	public String getTeacherName() {
    		return teacherName;
    	}

    	public void setTeacherName(String teacherName) {
    		this.teacherName = teacherName;
    	}

    	public String getTeacherMail() {
    		return teacherMail;
    	}

    	public void setTeacherMail(String teacherMail) {
    		this.teacherMail = teacherMail;
    	}
		
}
