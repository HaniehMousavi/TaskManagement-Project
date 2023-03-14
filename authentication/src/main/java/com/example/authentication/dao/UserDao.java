package com.example.authentication.dao;

import com.example.authentication.base.exception.CustomException;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Boolean update(String userId, ReqUserUpdateDTO entity);

    List<User> getList() throws CustomException;

}

