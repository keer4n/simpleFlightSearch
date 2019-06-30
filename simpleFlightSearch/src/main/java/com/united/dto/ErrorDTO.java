package com.united.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDTO extends RuntimeException{
	private String errorMessage;
	private Date errorTime;
	
	public ErrorDTO(String errorMessage, Date errorTime) {
		super();
		this.errorMessage = errorMessage;
		this.errorTime = errorTime;
	}
}
