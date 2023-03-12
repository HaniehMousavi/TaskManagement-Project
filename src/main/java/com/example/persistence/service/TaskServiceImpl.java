package com.example.persistence.service;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.util.SecurityUtils;
import com.example.persistence.dao.TaskDao;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.ReqTaskUpdateDTO;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao entityDao;

    @Override
    public Boolean create(Task entity) throws CustomException {
        return entityDao.save(entity);
    }

    @Override
    public Boolean update(String id, ReqTaskUpdateDTO entity) throws CustomException {
        return entityDao.update(id, entity);
    }

    @Override
    public Boolean updateTaskByUser(String id, ReqTaskUpdateDTO entity) throws CustomException {
        return entityDao.updateMyTask(id, entity);
    }

    @Override
    public List<ResTaskGetListDTO> getListMyTask() throws CustomException {
        String userId = SecurityUtils.getLoggedInUserId();
        return entityDao.getListMyTask(userId);
    }

    @Override
    public Boolean delete(String id) {
        return entityDao.deleteById(id);
    }

    @Override
    public Page<ResTaskGetPageDTO> getPage(String term, Pageable pageable) throws CustomException {
        return entityDao.findWithPaginationAsDTO(term, pageable);
    }

    @Override
    public List<ResTaskGetListDTO> getList(String term, Integer limit) throws CustomException {
        return entityDao.getListByTermAsDTO(term, limit);
    }

    @Override
    public ResTaskGetOneDTO getOne(String id) throws CustomException {
        return entityDao.getOneByIdAsDTO(id);
    }

}

