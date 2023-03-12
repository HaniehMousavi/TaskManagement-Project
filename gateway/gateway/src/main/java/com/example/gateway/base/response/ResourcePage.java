/**
 * 
 */
package com.example.gateway.base.response;

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
public class ResourcePage {

	private Integer page;
	private Integer size;
	private Long totalElements;
	private Integer totalPages;
}
