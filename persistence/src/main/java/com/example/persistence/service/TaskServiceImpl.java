package com.example.persistence.service;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.util.DecodedToken;
import com.example.persistence.base.util.Print;
import com.example.persistence.base.util.SecurityUtils;
import com.example.persistence.dao.TaskDao;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDao entityDao;

    @Override
    public Task create(Task entity) throws CustomException {
        return entityDao.save(entity);
    }

    @Override
    public Boolean update(Long id, ReqTaskUpdateDTO entity) throws CustomException {
        return entityDao.update(id, entity);
    }

    @Override
    public Boolean updateTaskByUser(Long id, ReqTaskUpdateDTO entity) throws CustomException {
        return entityDao.updateMyTask(id, entity);    }

    @Override
    public List<ResTaskGetListDTO> getListMyTask(Long categoryId, String token) throws CustomException, UnsupportedEncodingException {
        DecodedToken decodedToken = DecodedToken.getDecoded(token);
        if (token != null) {
            Long userId = decodedToken.userId;
            Print.print("userId", userId);
        }
        return entityDao.getListMyTask(categoryId, decodedToken.userId);
    }

    @Override
    public List<TaskGetListDTO> getListByCategoryId(Long categoryId) throws CustomException {
        return entityDao.getListByCategoryId(categoryId);
    }

    @Override
    public Boolean delete(Long id) {
        return entityDao.deleteById(id);
    }

    @Override
    public Page<ResTaskGetPageDTO> getPage(String term, Pageable pageable) throws CustomException {
        return entityDao.findWithPaginationAsDTO(term, pageable);
    }

    @Override
    public List<Task> getList() throws CustomException {
        return entityDao.getListByTermAsDTO();
    }

    @Override
    public ResTaskGetOneDTO getOne(Long id) throws CustomException {
        return entityDao.getOneByIdAsDTO(id);
    }

}

