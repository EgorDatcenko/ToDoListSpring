package com.example.to_do_list.dto;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, LocalDateTime dueDate) {
}
