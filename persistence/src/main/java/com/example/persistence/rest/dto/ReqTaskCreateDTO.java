
package com.example.persistence.rest.dto;

import com.example.persistence.domain.Task;
import com.example.persistence.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqTaskCreateDTO {

    private String title;
    private String description;
    private String comment;
    private Task.TaskStatus taskStatus;
//    private Set<User> user;
    private User user;

    public Task map() {
        Task result = new Task(this.title, this.description, this.comment, this.taskStatus,this.user);
        return result;
    }

}

