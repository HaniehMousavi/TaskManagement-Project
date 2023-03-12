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
public class QueryParamValidationException extends Exception {
	/*
	 * Name of query param has not valid
	 */
	private String queryParamName;

	public QueryParamValidationException(String queryParamName) {
		super();
		this.queryParamName = queryParamName;
	}
}
