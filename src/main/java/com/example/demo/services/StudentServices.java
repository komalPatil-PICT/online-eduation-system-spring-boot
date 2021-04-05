package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.AttemptedTest;
import com.example.demo.entity.OnlineTest;
import com.example.demo.entity.Timetable;
import com.example.demo.exception.StudentException;

public interface StudentServices
{
	public Timetable getTimetable(Integer std);
	public List<OnlineTest> getScheduledTest(int std);
	public OnlineTest getOnlineTestById(Long test_id);
	public AttemptedTest addAttemptedTest(AttemptedTest attemptedTest);
	public List<AttemptedTest> getAttemptedTest();
}
