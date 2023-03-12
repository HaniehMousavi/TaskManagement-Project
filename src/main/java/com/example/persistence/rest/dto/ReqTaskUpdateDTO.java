
package com.example.persistence.rest.dto;

import com.example.persistence.domain.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqTaskUpdateDTO {

    private String title;

    private String description;

    private String comment;

    private Task.TaskStatus taskStatus;

}

