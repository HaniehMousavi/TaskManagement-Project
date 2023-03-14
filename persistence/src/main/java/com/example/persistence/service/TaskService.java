package com.example.persistence.service;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface TaskService {

    Task create(Task entity) throws CustomException;

    Boolean update(String id, ReqTaskUpdateDTO entity) throws CustomException;

    Boolean updateTaskByUser(Long id, ReqTaskUpdateDTO entity) throws CustomException;

    Boolean delete(String id);

    Page<ResTaskGetPageDTO> getPage(String term, Pageable pageable) throws CustomException;

    List<Task> getList() throws CustomException;

    ResTaskGetOneDTO getOne(String id) throws CustomException;

    List<ResTaskGetListDTO> getListMyTask(Long categoryId, String token) throws CustomException, UnsupportedEncodingException;

    List<TaskGetListDTO> getListByCategoryId(Long categoryId) throws CustomException;
}

