package com.example.persistence.rest;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.exception.FieldValidationException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.*;
import com.example.persistence.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskResourceImpl implements TaskResource {
    private final TaskService entityService;

    @Override
    public ResponseEntity<List<ResTaskGetListDTO>> getListMyTask(Long categoryId, String token) throws CustomException, UnsupportedEncodingException {
        return ResponseEntity.ok().body(entityService.getListMyTask(categoryId, token));
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.delete(id));
    }

    @Override
    public ResponseEntity<Page<ResTaskGetPageDTO>> getPage(String term, Integer page, Integer size) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.getPage(term, PageRequest.of(page, size)));
    }


    @Override
    public ResponseEntity<List<Task>> getList() throws CustomException {
        return ResponseEntity.ok().body(entityService.getList());
    }

    @Override
    public ResponseEntity<List<TaskGetListDTO>> getListByCategoryId(Long categoryId) throws CustomException {
        return ResponseEntity.ok().body(entityService.getListByCategoryId(categoryId));
    }

    @Override
    public ResponseEntity<ResTaskGetOneDTO> getOne(Long id)
            throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.getOne(id));
    }

}

