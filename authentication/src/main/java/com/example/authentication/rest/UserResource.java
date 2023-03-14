package com.example.authentication.user;

import com.example.authentication.base.exception.CustomException;
import com.example.authentication.base.exception.FieldValidationException;
import com.example.authentication.base.response.ResourceResponse;
import com.example.authentication.domain.AuthenticationRequest;
import com.example.authentication.domain.AuthenticationResponse;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/user")
public interface UserResource {


    @GetMapping("/get-list")
    ResponseEntity<List<User>> getListAll() throws CustomException;


    @PutMapping("/update-user")
    ResponseEntity<Boolean> update(@RequestParam("id") String userId, @RequestBody ReqUserUpdateDTO entity)
            throws CustomException, FieldValidationException;

    @PostMapping("/signup/{role}")
    ResponseEntity<ResourceResponse<User>> createUser(@PathVariable String role, @RequestBody User user) throws CustomException;


    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws CustomException;


}

