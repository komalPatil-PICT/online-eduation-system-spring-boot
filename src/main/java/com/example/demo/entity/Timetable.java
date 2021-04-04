package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.convertor.ScheduleConvertor;

@Entity
public class Timetable {
	
	@Id
	private Integer std;
	private String date;

	@Convert(converter = ScheduleConvertor.class)
	@Column(columnDefinition = "json")
	private List<Schedule> schedule = new ArrayList<Schedule>();

	public Timetable() {
		super();
	}

	public Timetable(Integer std, String date, List<Schedule> schedule) {
		super();
		this.std = std;
		this.date = date;
		this.schedule = schedule;
	}

	public Integer getStd() {
		return std;
	}

	public void setStd(Integer std) {
		this.std = std;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Timetable [std=" + std + ", date=" + date + ", schedule=" + schedule + "]";
	}
}
