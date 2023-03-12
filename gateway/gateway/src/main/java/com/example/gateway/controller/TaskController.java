package com.example.gateway.controller;

import com.example.gateway.base.constants.Roles;
import com.example.gateway.base.exception.CustomException;
import com.example.gateway.base.exception.FieldValidationException;
import com.example.gateway.domain.*;
import com.example.gateway.feign.PersistenceFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gateway.config.Queues.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task/")
public class TaskController {
    private final RabbitTemplate rabbitTemplate;
    private final PersistenceFeign persistenceFeign;

    @PostMapping("/create-task-by-admin")
    @PreAuthorize(Roles.ROLE_ADMIN)
    public ResponseEntity<Boolean> create(@RequestBody TaskDto entity) {
        Boolean result = (Boolean) rabbitTemplate.convertSendAndReceive(CREATE_TASK, entity);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update-by-admin")
    @PreAuthorize(Roles.ROLE_ADMIN)
    public ResponseEntity<Boolean> updateByAdmin(@RequestBody ReqTaskUpdateDTO entity) {
        Boolean body = (Boolean) rabbitTemplate.convertSendAndReceive(UPDATE_BY_ADMIN, entity);
        return ResponseEntity.ok().body(body);
    }

    @PutMapping("/update-by-user")
    public ResponseEntity<Boolean> updateTaskByUser(@RequestBody ReqTaskUpdateDTO entity) {
        Boolean res = (Boolean) rabbitTemplate.convertSendAndReceive(UPDATE_TASK_BY_USER, entity);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/get-list")
    public ResponseEntity<List<ResTaskGetListDTO>> getListMyTask() throws CustomException {
        List<ResTaskGetListDTO> res = (List<ResTaskGetListDTO>) persistenceFeign.getListMyTask();
        return ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/delete-by-admin")
    @PreAuthorize(Roles.ROLE_ADMIN)
    public ResponseEntity<Boolean> delete(@RequestParam("id") String id) throws FieldValidationException, CustomException {
        Boolean res = persistenceFeign.delete(id).getBody();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/get-page")
    public ResponseEntity<Page<ResTaskGetPageDTO>> getPage(@RequestParam(value = "term", required = false, defaultValue = "") String term,
                                                           @RequestParam("page") Integer page, @RequestParam("size") Integer size) throws FieldValidationException, CustomException {
        Page<ResTaskGetPageDTO> res = (Page<ResTaskGetPageDTO>) persistenceFeign.getPage(term, page, size);
        return ResponseEntity.ok().body(res);
    }


    @GetMapping("/get-one")
    public ResponseEntity<ResTaskGetOneDTO> getOne(@RequestParam("id") String id) throws FieldValidationException, CustomException {
        ResTaskGetOneDTO res = (ResTaskGetOneDTO) persistenceFeign.getOne(id);
        return ResponseEntity.ok().body(res);
    }
}
