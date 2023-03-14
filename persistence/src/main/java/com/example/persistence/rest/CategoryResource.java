package com.example.persistence.rest;

import com.example.persistence.base.constants.Roles;
import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.exception.FieldValidationException;
import com.example.persistence.domain.Category;
import com.example.persistence.rest.dto.ResTaskGetListDTO;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RequestMapping("/api/category")
public interface CategoryResource {

    @PostMapping("/create-category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If entity created return true otherwise return false", response = Boolean.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_ADMIN)
    ResponseEntity<Category> create(@RequestBody Category entity) throws CustomException, FieldValidationException;

    @GetMapping("/get-list-category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return list of entity or null", response = ResTaskGetListDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    ResponseEntity<List<Category>> getListCategory() throws CustomException, UnsupportedEncodingException;
}
