package com.example.gateway.feign;


import com.example.gateway.base.constants.Roles;
import com.example.gateway.base.exception.CustomException;
import com.example.gateway.base.exception.FieldValidationException;
import com.example.gateway.domain.ResTaskGetListDTO;
import com.example.gateway.domain.ResTaskGetOneDTO;
import com.example.gateway.domain.ResTaskGetPageDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("persistence")
public interface PersistenceFeign {

    final String entityName = "task/";
    final String prefix = "/api/" + entityName;

    ResponseEntity<List<ResTaskGetListDTO>> getListMyTask() throws CustomException;


    @DeleteMapping(prefix + "/delete-by-admin")
    @PreAuthorize(Roles.ROLE_ADMIN)
    ResponseEntity<Boolean> delete(@RequestParam("id") String id) throws CustomException, FieldValidationException;


    @GetMapping(prefix + "/get-page")
    ResponseEntity<Page<ResTaskGetPageDTO>> getPage(
            @RequestParam(value = "term", required = false, defaultValue = "") String term,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) throws CustomException, FieldValidationException;


    @GetMapping(prefix + "/get-list-by-term")
    ResponseEntity<List<ResTaskGetListDTO>> getList(
            @RequestParam(value = "term", required = false, defaultValue = "") String term,
            @RequestParam("limit") Integer limit) throws CustomException;


    @GetMapping(prefix + "/get-one")
    ResponseEntity<ResTaskGetOneDTO> getOne(@RequestParam("id") String id) throws CustomException, FieldValidationException;


}
