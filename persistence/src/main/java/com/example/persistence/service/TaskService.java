package com.example.persistence.service;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.ReqTaskUpdateDTO;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TaskService {

    Boolean create(Task entity) throws CustomException;

    Boolean update(String id, ReqTaskUpdateDTO entity) throws CustomException;

    Boolean updateTaskByUser(String id, ReqTaskUpdateDTO entity) throws CustomException;

    Boolean delete(String id);

    Page<ResTaskGetPageDTO> getPage(String term, Pageable pageable) throws CustomException;

    List<ResTaskGetListDTO> getList(String term, Integer limit) throws CustomException;

    ResTaskGetOneDTO getOne(String id) throws CustomException;

    List<ResTaskGetListDTO> getListMyTask() throws CustomException;
}

