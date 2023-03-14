package com.example.authentication.repository.user;


import com.example.authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_management.Users " +
            "SET firstName = :firstName, lastName = :lastName, username = :username, password = :password " +
            "WHERE id = :id ",nativeQuery = true)
    Optional<Integer> update(@Param("id") String id,
                             @Param("firstName") String firstName,
                             @Param("lastName") String lastName,
                             @Param("username") String username,
                             @Param("password") String password);


    @Query("SELECT u.username as username " +
            "FROM User As u " +
            "WHERE (:username IS NULL OR u.username = :username)")
    User existsUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(" UPDATE User " +
            "SET firstName = :firstName, lastName = :lastName " +
            "WHERE id = :id ")
    Integer setFirstNameLastName(@Param("id") Long id,
                                 @Param("firstName") String firstName,
                                 @Param("lastName") String lastName);


    Optional<User> findByUsername(String username);


}

