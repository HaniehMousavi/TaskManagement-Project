package com.example.persistence.base.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceResponse<T> {

	Object data = null;
	Boolean flag = null;

	List<State> states = null;

	/**
	 * 
	 */
	public ResourceResponse(Boolean flag, ResourseKeyword keyword, String message) {
		this.flag = flag ? true : false;
		this.states = Arrays.asList(new State(keyword, message));
	}

	public ResourceResponse(Boolean flag, ResourseKeyword keyword) {
		this.flag = flag ? true : false;
		this.states = Arrays.asList(new State(keyword));
	}

	/**
	 * 
	 */
	public ResourceResponse(List<T> list) {
		if (list != null && list.size() > 0) {
			this.flag = true;
			this.data = list;
		} else {
			this.flag = false;
			this.states = Arrays.asList(new State(ResourseKeyword.NOT_FOUND, ""));
		}
	}

	/**
	 * 
	 */
	public ResourceResponse(Object data) {
		if (data != null) {
			this.flag = true;
			this.data = data;
		} else {
			this.flag = false;
			this.states = Arrays.asList(new State(ResourseKeyword.NOT_FOUND, ""));
		}
	}

	public void addState(ResourseKeyword keyword, String message) {
		this.setFlag(false);
		if (this.states == null)
			this.states = new ArrayList<>();
		this.states.add(new State(keyword, message));
	}
}
