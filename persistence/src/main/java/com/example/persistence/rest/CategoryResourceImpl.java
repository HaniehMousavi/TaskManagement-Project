package com.example.persistence.rest;

import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.exception.FieldValidationException;
import com.example.persistence.domain.Category;
import com.example.persistence.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryResourceImpl implements CategoryResource {
    private final CategoryService entityService;

    @Override
    public ResponseEntity<Category> create(Category entity) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.create(entity));
    }

    @Override
    public ResponseEntity<List<Category>> getListCategory() throws CustomException, UnsupportedEncodingException {
        return ResponseEntity.ok().body(entityService.getListCategory());
    }
}
