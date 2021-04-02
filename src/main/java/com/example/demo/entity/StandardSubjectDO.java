package com.example.demo.entity;

import com.example.demo.enums.TeacherStatus;

public class StandardSubjectDO {

	private Long std_id;
	private Long sub_id;
	private Long teacher_id;
	private TeacherStatus teacherStatus;
	
	public StandardSubjectDO() {
		
	}
	
	public Long getStd_id() {
		return std_id;
	}
	public void setStd_id(Long std_id) {
		this.std_id = std_id;
	}
	public Long getSub_id() {
		return sub_id;
	}
	public void setSub_id(Long sub_id) {
		this.sub_id = sub_id;
	}

	public Long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public TeacherStatus getTeacherStatus() {
		return teacherStatus;
	}

	public void setTeacherStatus(TeacherStatus teacherStatus) {
		this.teacherStatus = teacherStatus;
	}

	
	
	
}
