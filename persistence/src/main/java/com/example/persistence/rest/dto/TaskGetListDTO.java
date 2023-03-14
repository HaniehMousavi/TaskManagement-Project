package com.example.persistence.rest.dto;

public interface TaskGetListDTO {
    Long getId();
    String getTitle();
    String getDescription();
    String getComment();
    String getTaskStatus();
    Long getCategoryId();
    String getCategoryTitle();
}
