package com.example.persistence.base.exception;

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
public class NullFieldException extends Exception {
	/*
	 * Name of entity has null field
	 */
	private String entityName;
	/*
	 * Name of empty field
	 */
	private String fieldName;

	public NullFieldException(String entityName, Object fieldName) {
		super();
		this.entityName = entityName;
		this.fieldName = fieldName.toString();
	}

}