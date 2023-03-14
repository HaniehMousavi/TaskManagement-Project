package com.example.authentication.dao;


import com.example.authentication.base.exception.CustomException;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;
import com.example.authentication.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository entityRepository;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    @Override
    public Boolean update(String userId, ReqUserUpdateDTO entity) {
        String hashPassword = encoder.encode(entity.getPassword());
        Optional<Integer> optionalInteger = entityRepository.update(userId, entity.getFirstName(), entity.getLastName(), entity.getUsername(), hashPassword);
        return optionalInteger.isPresent() && optionalInteger.get() > 0;
    }

    @Override
    public List<User> getList() throws CustomException {
        return entityRepository.findAll();
//                .orElseThrow(() -> new CustomException("دیتا یافت نشد"));
    }

}

