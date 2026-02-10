package com.example.to_do_list.service;

import com.example.to_do_list.dto.TaskRequest;
import com.example.to_do_list.dto.TaskResponse;
import com.example.to_do_list.exception.NoFoundTaskException;
import com.example.to_do_list.model.Task;
import com.example.to_do_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponse createTask(TaskRequest taskRequest){
        Task task = Task.builder().title(taskRequest.title()).description(taskRequest.description()).dueDate(taskRequest.dueDate()).build();
        taskRepository.save(task);
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate());
    }

    public TaskResponse getTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty()){
            throw new NoFoundTaskException("Задача не найдена");
        }
        Task getTask = task.get();
        return new TaskResponse(getTask.getId(), getTask.getTitle(), getTask.getDescription(), getTask.getDueDate());
    }
}
