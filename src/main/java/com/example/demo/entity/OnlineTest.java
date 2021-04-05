package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.convertor.QuestionDescConvertor;

@Entity
public class OnlineTest {
	@Id
	long testId;
	
	int std;
	int totalMarks;
	int totalQuestions;
	float time;
	String createdDate;
	String conductedDate;
	String status;

	@Convert(converter = QuestionDescConvertor.class)
	@Column(columnDefinition = "json")
	private List<QuestionDesc> questions = new ArrayList<QuestionDesc>();

	public OnlineTest(long testId, int std, int totalMarks, int totalQuestions, float time, String createdDate,
			String conductedDate, String status, List<QuestionDesc> questions) {

		this.testId = testId;
		this.std = std;
		this.totalMarks = totalMarks;
		this.totalQuestions = totalQuestions;
		this.time = time;
		this.createdDate = createdDate;
		this.conductedDate = conductedDate;
		this.status = status;
		this.questions = questions;
	}

	public OnlineTest() {

	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getConductedDate() {
		return conductedDate;
	}

	public void setConductedDate(String conductedDate) {
		this.conductedDate = conductedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public List<QuestionDesc> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDesc> questions) {
		this.questions = questions;
	}

}
