package com.example.authentication.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If some field is null for some validation throw this exception
 * 
 * @author yaqub
 *
 */
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TelephoneValidationException extends Exception {
	/*
	 * Name of entity has null field
	 */
	private String entityName;
	/*
	 * Name of empty field
	 */
	private String fieldName;

	/*
	 * Incorrect email
	 */
	private String telephone;

	public TelephoneValidationException(String entityName, Object fieldName, String telephone) {
		super();
		this.entityName = entityName;
		this.fieldName = fieldName.toString();
		this.telephone = telephone;
	}

}
