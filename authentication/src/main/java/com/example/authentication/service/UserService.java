package com.example.authentication.service;

import com.example.authentication.domain.AuthenticationRequest;
import com.example.authentication.domain.AuthenticationResponse;
import com.example.authentication.base.exception.CustomException;
import com.example.authentication.base.response.ResourceResponse;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;

import java.util.List;


public interface UserService {

    ResourceResponse<User> createUser(String role, User user) throws CustomException;

    AuthenticationResponse authenticate(AuthenticationRequest request) throws CustomException;

    Boolean update(String id, ReqUserUpdateDTO entity);

    List<User> getList() throws CustomException;

}

