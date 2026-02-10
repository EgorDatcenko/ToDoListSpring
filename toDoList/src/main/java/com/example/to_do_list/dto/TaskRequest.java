package com.example.to_do_list.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskRequest(@NotBlank(message = "Название задачи не может быть пустым")
                          String title,
                          String description,
                          @NotNull(message = "Дата выполнения не может быть пустой")
                          @Future(message = "Дата выполнения должна быть в будущем")
                          LocalDateTime dueDate) {
}
