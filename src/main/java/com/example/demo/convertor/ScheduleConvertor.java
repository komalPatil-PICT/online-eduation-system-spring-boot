package com.example.demo.convertor;

import java.util.List;

import javax.persistence.AttributeConverter;

import com.example.demo.entity.Schedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScheduleConvertor implements AttributeConverter<List<Schedule>, String> {
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();

	}

	@Override
	public String convertToDatabaseColumn(List<Schedule> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public List<Schedule> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData, new TypeReference<List<Schedule>>() {
			});
		} catch (Exception e) {
			return null;
		}
	}
}
