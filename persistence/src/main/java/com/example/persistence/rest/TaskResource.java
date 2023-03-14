package com.example.persistence.rest;

import com.example.persistence.base.constants.Roles;
import com.example.persistence.base.exception.CustomException;
import com.example.persistence.base.exception.FieldValidationException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.*;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;


@RequestMapping("/api/task")
public interface TaskResource {

    @PostMapping("/create-task-by-admin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If entity created return true otherwise return false", response = Boolean.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_ADMIN)
    ResponseEntity<Task> create(@RequestBody Task entity) throws CustomException, FieldValidationException;


    @PutMapping("/update-by-admin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If entity updated return true otherwise return false or throw exception", response = Boolean.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_ADMIN)
    ResponseEntity<Boolean> updateByAdmin(@RequestParam("id") String id, @RequestBody ReqTaskUpdateDTO entity)
            throws CustomException, FieldValidationException;

    @PutMapping("/update-by-user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If entity updated return true otherwise return false or throw exception", response = Boolean.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_USER)
    ResponseEntity<Boolean> updateTaskByUser(@RequestParam("id") Long id, @RequestBody ReqTaskUpdateDTO entity)
            throws CustomException, FieldValidationException;


    @GetMapping("/get-list-task-by-user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return list of entity or null", response = ResTaskGetListDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_USER)
    ResponseEntity<List<ResTaskGetListDTO>> getListMyTask(@RequestParam("categoryId") Long categoryId, @RequestHeader("token") String token) throws CustomException, UnsupportedEncodingException;


    @DeleteMapping("/delete-by-admin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "If entity deleted return true otherwise return false or throw exception", response = Boolean.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    @PreAuthorize(Roles.ROLE_ADMIN)
    ResponseEntity<Boolean> delete(@RequestParam("id") String id) throws CustomException, FieldValidationException;


    @GetMapping("/get-page")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return page of entity or null", response = ResTaskGetPageDTO.class, responseContainer = "Page"),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    ResponseEntity<Page<ResTaskGetPageDTO>> getPage(
            @RequestParam(value = "term", required = false, defaultValue = "") String term,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) throws CustomException, FieldValidationException;


    @GetMapping("/get-list-task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return list of entity or null", response = ResTaskGetListDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    ResponseEntity<List<Task>> getList() throws CustomException;


    @GetMapping("/get-list-task-by-categoryId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return list of entity or null", response = ResTaskGetListDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    ResponseEntity<List<TaskGetListDTO>> getListByCategoryId(@RequestParam("categoryId") Long categoryId) throws CustomException;

    @GetMapping("/get-one")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = ResTaskGetOneDTO.class),
            @ApiResponse(code = 400, message = "throws Object", response = Object.class)})
    ResponseEntity<ResTaskGetOneDTO> getOne(@RequestParam("id") String id)
            throws CustomException, FieldValidationException;
}

