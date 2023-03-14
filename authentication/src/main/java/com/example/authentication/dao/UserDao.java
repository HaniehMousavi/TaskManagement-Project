package com.example.authentication.dao;

import com.example.authentication.base.exception.CustomException;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;

import java.util.List;

public interface UserDao {

    Boolean update(String userId, ReqUserUpdateDTO entity);

    List<User> getList() throws CustomException;

}

