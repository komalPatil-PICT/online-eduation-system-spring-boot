package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.convertor.ScheduleLectureConvertor;



@Entity
public class TimeTable {
	


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Timetable_Id")
	private long timetable_id;
	
	@Column(name="Standard")
	private String std;
	
	@Column(name="Date")
	private Date date;
	
	
	@Convert(converter = ScheduleLectureConvertor.class)
	@Column(columnDefinition = "json")
	private List<ScheduleLecture> lectures = new ArrayList();

	public TimeTable(long timetable_id, String std, Date date, List<ScheduleLecture> lectures) {
		super();
		this.timetable_id = timetable_id;
		this.std = std;
		this.date = date;
		this.lectures = lectures;
	}

	public long getTimetable_id() {
		return timetable_id;
	}

	public void setTest_id(long timetable_id) {
		this.timetable_id = timetable_id;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ScheduleLecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<ScheduleLecture> lectures) {
		this.lectures = lectures;
	}
	
	

}
