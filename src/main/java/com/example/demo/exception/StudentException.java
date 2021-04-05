package com.example.demo.exception;

public class StudentException extends Exception
{
	private String message;

	public StudentException() {
		this.message = "";
	}

	public StudentException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentException [message=" + message + "]";
	}
}
