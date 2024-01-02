package com.example.todolist.domain.task.dto

import java.time.LocalDateTime

data class TaskResponse(
        val id: Long,
        val name: String,
        val title: String,
        val comment: String?,
        val time: LocalDateTime
)
