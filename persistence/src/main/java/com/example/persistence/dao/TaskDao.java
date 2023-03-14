package com.example.persistence.dao;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TaskDao {

    Task save(Task entity);

    Boolean update(Long id, ReqTaskUpdateDTO entity);

    Boolean deleteById(Long id);

    Page<ResTaskGetPageDTO> findWithPaginationAsDTO(String term, Pageable pageable) throws CustomException;

    List<Task> getListByTermAsDTO() throws CustomException;

    ResTaskGetOneDTO getOneByIdAsDTO(Long id) throws CustomException;

    Boolean updateMyTask(Long id, ReqTaskUpdateDTO entity);

    List<ResTaskGetListDTO> getListMyTask(Long categoryId, Long userId) throws CustomException;

    List<ResTaskGetListDTO> getListTasks(Long id) throws CustomException;

    List<TaskGetListDTO> getListByCategoryId(Long categoryId) throws CustomException;
}

