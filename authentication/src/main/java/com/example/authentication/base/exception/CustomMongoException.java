package com.example.authentication.base.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
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
//@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomMongoException extends Exception {
	/*
	 * Name of entity(or collection of MongoDB) has error
	 */
	private String collectionName;

	/*
	 * MongoDB real exception
	 */
	private Exception ex;

	public CustomMongoException(String collectionName, Exception ex) {
		super(ex.getMessage());
		this.collectionName = collectionName;
	}

}
