package com.example.persistence.base.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class State {
	ResourseKeyword keyword;
	String message;

	public State(ResourseKeyword keyword) {
		this.keyword = keyword;
	}
}