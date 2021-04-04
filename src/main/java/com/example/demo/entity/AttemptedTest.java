package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.convertor.AnswerSheetConvertor;

@Entity
public class AttemptedTest {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Long test_id;
	private Integer std;
	private String subject;
	private Long rollNo;
	
	@Convert(converter = AnswerSheetConvertor.class)
	@Column(columnDefinition = "json")
	private List<AnswerSheet> answerSheet = new ArrayList<AnswerSheet>();
	
	private Integer score;

	public AttemptedTest() {
		super();
	}

	public AttemptedTest(Long test_id, Integer std, String subject, Long rollNo, List<AnswerSheet> answerSheet,
			Integer score) {
		super();
		this.test_id = test_id;
		this.std = std;
		this.subject = subject;
		this.rollNo = rollNo;
		this.answerSheet = answerSheet;
		this.score = score;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	public Integer getStd() {
		return std;
	}

	public void setStd(Integer std) {
		this.std = std;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public List<AnswerSheet> getAnswerSheet() {
		return answerSheet;
	}

	public void setAnswerSheet(List<AnswerSheet> answerSheet) {
		this.answerSheet = answerSheet;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "AttemptedTest [test_id=" + test_id + ", std=" + std + ", subject=" + subject + ", rollNo=" + rollNo
				+ ", answerSheet=" + answerSheet + ", score=" + score + "]";
	}
}
