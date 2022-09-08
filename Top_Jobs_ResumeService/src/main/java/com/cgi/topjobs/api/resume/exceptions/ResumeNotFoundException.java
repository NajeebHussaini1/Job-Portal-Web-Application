package com.cgi.topjobs.api.resume.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResumeNotFoundException extends RuntimeException{
 
	public ResumeNotFoundException(String message) {
		super(message);
	}
	
	
	
	
}
