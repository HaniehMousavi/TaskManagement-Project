package com.example.gateway.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FieldValidationException extends Exception {
	/*
	 * Name of field has not valid
	 */
	private String fieldName;

	public FieldValidationException(String fieldName) {
		super();
		this.fieldName = fieldName;
	}
}
