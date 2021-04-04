package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Standard;
import com.example.demo.entity.StandardSubjectDO;
import com.example.demo.entity.StandardSubjects;
import com.example.demo.exception.StandardException;
import com.example.demo.exception.StandardSubjectException;

public interface StandardSubjectsService {

	public StandardSubjects assignSubjectsToStandard(StandardSubjectDO standardSubjectDo)throws StandardSubjectException;
	public List<StandardSubjects> getAllRows()throws StandardSubjectException;
	public List<StandardSubjects> findAllByTeacherId(Long id)throws StandardSubjectException;
}
