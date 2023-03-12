package com.example.persistence.rest;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.exception.FieldValidationException;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import com.example.persistence.rest.dto.ResTaskGetOneDTO;
import com.example.persistence.rest.dto.ResTaskGetPageDTO;
import com.example.persistence.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskResourceImpl implements TaskResource {
    private final TaskService entityService;

    @Override
    public ResponseEntity<List<ResTaskGetListDTO>> getListMyTask() throws CustomException {
        return ResponseEntity.ok().body(entityService.getListMyTask());
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.delete(id));
    }

    @Override
    public ResponseEntity<Page<ResTaskGetPageDTO>> getPage(String term, Integer page, Integer size) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.getPage(term, PageRequest.of(page, size)));
    }


    @Override
    public ResponseEntity<List<ResTaskGetListDTO>> getList(String term, Integer limit) throws CustomException {
        return ResponseEntity.ok().body(entityService.getList(term,limit));
    }

    @Override
    public ResponseEntity<ResTaskGetOneDTO> getOne(String id)
            throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.getOne(id));
    }
}

