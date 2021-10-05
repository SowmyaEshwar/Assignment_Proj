package com.te.jpqlassignment.dao;

public class InvalidOptionException extends RuntimeException{
	String message;

	public InvalidOptionException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
