package com.example.gateway.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If query for MongoDB can not found any document throw this exception
 * 
 * @author yaqub
 *
 */
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.CONFLICT)
public class DocumentUpdateException extends Exception {
	/*
	 * Name of entity
	 */
	private String entityName;

	public DocumentUpdateException(String entityName) {
		super();
		this.entityName = entityName;
	}

}
