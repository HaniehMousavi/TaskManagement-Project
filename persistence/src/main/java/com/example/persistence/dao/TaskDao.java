package com.example.persistence.dao;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.ReqTaskUpdateDTO;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TaskDao {

    Boolean save(Task entity);

    Boolean update(String id, ReqTaskUpdateDTO entity);

    Boolean deleteById(String id);

    Page<ResTaskGetPageDTO> findWithPaginationAsDTO(String term, Pageable pageable) throws CustomException;

    List<ResTaskGetListDTO> getListByTermAsDTO(String term, Integer limit) throws CustomException;

    ResTaskGetOneDTO getOneByIdAsDTO(String id) throws CustomException;

    Boolean updateMyTask(String id, ReqTaskUpdateDTO entity);

    List<ResTaskGetListDTO> getListMyTask(String userId) throws CustomException;

    List<ResTaskGetListDTO> getListTasks(String id) throws CustomException;
}

