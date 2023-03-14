//package com.example.authentication.rest;
//
//import com.example.authentication.base.exception.CustomException;
//import com.example.authentication.base.response.ResourceResponse;
//import com.example.authentication.domain.AuthenticationRequest;
//import com.example.authentication.domain.AuthenticationResponse;
//import com.example.authentication.domain.User;
//import com.example.authentication.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
//import static com.example.authentication.configRabbit.Queues.USER_SIGNUP;
//import static com.example.authentication.configRabbit.Queues.USER_SIGN_IN;
//
//@Component
//@RequiredArgsConstructor
//public class UserConsumer {
//
//    private final UserService entityService;
//
////    @SendTo
////    @RabbitListener(queues = USER_SIGNUP, returnExceptions = "true")
//    public ResourceResponse<User> createUser(String role, User user) throws CustomException {
//        return entityService.createUser(role,user);
//    }
//
////    @SendTo
////    @RabbitListener(queues = USER_SIGN_IN, returnExceptions = "true")
//    public AuthenticationResponse authenticate(AuthenticationRequest request) throws CustomException {
//        return entityService.authenticate(request);
//    }
//
//}
