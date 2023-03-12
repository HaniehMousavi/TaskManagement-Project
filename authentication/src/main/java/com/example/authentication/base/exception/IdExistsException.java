package com.example.authentication.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If id is exist for some validation throw this exception
 * 
 * @author yaqub
 *
 */
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IdExistsException extends Exception {
	/*
	 * Name of entity has not null id field
	 */
	private String entityName;

	public IdExistsException(String entityName, String message) {
		super(message);
		this.entityName = entityName;
	}
}
