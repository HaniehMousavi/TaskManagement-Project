package com.example.authentication.rest;

import com.example.authentication.base.exception.CustomException;
import com.example.authentication.base.exception.FieldValidationException;
import com.example.authentication.base.response.ResourceResponse;
import com.example.authentication.domain.AuthenticationRequest;
import com.example.authentication.domain.AuthenticationResponse;
import com.example.authentication.domain.User;

import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;
import com.example.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResourceImpl implements com.example.authentication.user.UserResource {
    private final UserService entityService;


    @Override
    public ResponseEntity<ResourceResponse<User>> createUser(String role, User user) throws CustomException {
        return ResponseEntity.ok().body(entityService.createUser(role, user));
    }

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) throws CustomException {
        return ResponseEntity.ok().body(entityService.authenticate(request));
    }


//    private final UserService entityService;
//
    @Override
    public ResponseEntity<List<User>> getListAll() throws CustomException {
        return ResponseEntity.ok().body(entityService.getList());
    }

    @Override
    public ResponseEntity<Boolean> update(String id, ReqUserUpdateDTO entity) throws CustomException, FieldValidationException {
        return ResponseEntity.ok().body(entityService.update(id, entity));
    }

}

