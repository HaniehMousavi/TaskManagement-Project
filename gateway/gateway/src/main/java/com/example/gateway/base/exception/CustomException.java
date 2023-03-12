package com.example.gateway.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A custom exception with custom message ;)
 * 
 * @author farzad
 *
 */
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException extends Exception {
	/*
	 * Name of entity has null field
	 */
	private String reason;


	public CustomException(String reason) {
		super();
		this.reason = reason;
	}

}
