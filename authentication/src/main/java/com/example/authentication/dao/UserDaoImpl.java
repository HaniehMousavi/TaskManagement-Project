package com.example.authentication.dao;


import com.example.authentication.dto.ReqUserUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

//    private final UserRepository entityRepository;


//    @Override
//    public Boolean update(String userId, ReqUserUpdateDTO entity) {
//        Optional<Integer> optionalInteger = entityRepository.update(userId, entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword());
//        return optionalInteger.isPresent() && optionalInteger.get() > 0;
//    }

//    @Override
//    public List<ResUserGetListDTO> getList(String userId) {
//        return entityRepository.getListById(userId).orElseThrow(() -> new CustomException("دیتا یافت نشد"));
//    }

}

