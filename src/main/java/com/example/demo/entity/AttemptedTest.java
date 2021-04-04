package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;

import com.example.demo.convertor.AnswerSheetConvertor;

@Entity
public class AttemptedTest {
	
	private Long test_id;
	
	@Convert(converter = AnswerSheetConvertor.class)
	@Column(columnDefinition = "json")
	private List<AnswerSheet> answerSheet = new ArrayList<AnswerSheet>();
	
	private Integer score;

	public AttemptedTest() {
		super();
	}

	public AttemptedTest(Long test_id, List<AnswerSheet> answerSheet, Integer score) {
		super();
		this.test_id = test_id;
		this.answerSheet = answerSheet;
		this.score = score;
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
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
		return "AttemptedTest [test_id=" + test_id + ", answerSheet=" + answerSheet + ", score=" + score + "]";
	}
	
}
