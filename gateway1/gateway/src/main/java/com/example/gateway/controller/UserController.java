package com.example.gateway.controller;

import com.example.gateway.base.exception.CustomException;
import com.example.gateway.base.response.ResourceResponse;
import com.example.gateway.base.util.Print;
import com.example.gateway.domain.AuthenticationRequest;
import com.example.gateway.domain.AuthenticationResponse;
import com.example.gateway.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import static com.example.gateway.config.Queues.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
@Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/signup/{role}")
    public ResponseEntity<ResourceResponse<UserDto>> createUser(@RequestBody UserDto user) throws CustomException {
        Print.print("userrrrrrrrrrrrr", user);
//         rabbitTemplate.convertAndSend(exchange,routingKey, user);
                UserDto result = (UserDto) rabbitTemplate.convertSendAndReceive(USER_SIGN_IN, user);

        return ResponseEntity.ok().body(new ResourceResponse<>(result));
    }

    @PostMapping("/signin")
    public ResponseEntity<ResourceResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest request) throws CustomException {
        AuthenticationResponse result = (AuthenticationResponse) rabbitTemplate.convertSendAndReceive(USER_SIGN_IN, request);
        return ResponseEntity.ok().body(new ResourceResponse<>(result));
    }

}
