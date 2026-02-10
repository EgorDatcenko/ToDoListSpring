package com.example.to_do_list.controller;

import com.example.to_do_list.dto.TaskRequest;
import com.example.to_do_list.dto.TaskResponse;
import com.example.to_do_list.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.to_do_list.model.Task;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<TaskResponse> postTask(@Valid @RequestBody TaskRequest taskRequest){
        TaskResponse task = taskService.createTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
        TaskResponse task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
}
