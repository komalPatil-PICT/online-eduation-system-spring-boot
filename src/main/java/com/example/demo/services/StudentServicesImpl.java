package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttemptedTest;
import com.example.demo.entity.OnlineTest;
import com.example.demo.entity.Timetable;
import com.example.demo.repository.AttemptedTestRepository;
import com.example.demo.repository.OnlineTestRepo;
/*import com.example.demo.repository.StudentRepository;*/
import com.example.demo.repository.TimetableRepository;

@Service
public class StudentServicesImpl implements StudentServices
{
	/*
	 * @Autowired private StudentRepository studentRepository;
	 */
	@Autowired
	private OnlineTestRepo onlineTestRepository;
	@Autowired
	private TimetableRepository timetableRepository;
	@Autowired
	private AttemptedTestRepository attemptedTestRepository;
	
	@Override
	public Timetable getTimetable(Integer std)
	{
		Timetable timetable = timetableRepository.getOne(std);
		if(timetable!=null)
		{
			return timetable;
		}
		else
		{
			return null;
		}
	}

	@Override
	public OnlineTest getOnlineTestById(Long test_id) {
		OnlineTest onlineTest = onlineTestRepository.getOne(test_id);
		return onlineTest;
	}

	@Override
	public AttemptedTest addAttemptedTest(AttemptedTest attemptedTest) {
		List<AttemptedTest> attemptedTestsList = attemptedTestRepository.findAll();
		int test = 0;
		for(AttemptedTest alreadyAttemptedTest: attemptedTestsList)
		{
			if(alreadyAttemptedTest.getTest_id()==attemptedTest.getTest_id())
			{
				test++;
				break;
			}
			else
			{
				continue;
			}
		}
		if(test==0)
		{
			AttemptedTest newAttemptedTest = attemptedTestRepository.saveAndFlush(attemptedTest);
			return newAttemptedTest;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<AttemptedTest> getAttemptedTest() {
		List<AttemptedTest> allAttemptedTests = attemptedTestRepository.findAll();
		return allAttemptedTests;
	}

}
