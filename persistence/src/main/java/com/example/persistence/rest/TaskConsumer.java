package com.example.persistence.rest;


import com.example.persistence.base.exception.CustomException;
import com.example.persistence.domain.Task;
import com.example.persistence.rest.dto.ReqTaskUpdateDTO;
import com.example.persistence.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import static com.example.persistence.config.RabbitMQConfig.*;


@Component
@RequiredArgsConstructor
public class TaskConsumer {

    private final TaskService entityService;

    @SendTo
    @RabbitListener(queues = CREATE_TASK, returnExceptions = "true")
    public ResponseEntity<Boolean> create(Task entity) throws CustomException {
        return ResponseEntity.ok().body(entityService.create(entity));
    }

    @SendTo
    @RabbitListener(queues = UPDATE_BY_ADMIN, returnExceptions = "true")
    public ResponseEntity<Boolean> updateByAdmin(String id, ReqTaskUpdateDTO entity) throws CustomException {
        return ResponseEntity.ok().body(entityService.update(id, entity));
    }

    @SendTo
    @RabbitListener(queues = UPDATE_TASK_BY_USER, returnExceptions = "true")
    public ResponseEntity<Boolean> updateTaskByUser(String id, ReqTaskUpdateDTO entity) throws CustomException {
        return ResponseEntity.ok().body(entityService.updateTaskByUser(id, entity));
    }

}
