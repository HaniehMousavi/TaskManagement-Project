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
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class DocumentNotFoundException extends Exception {
	/*
	 * Name of entity
	 */
	private String entityName;

	public DocumentNotFoundException(String entityName) {
		super();
		this.entityName = entityName;
	}

}
