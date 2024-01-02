package com.example.todolist.domain.task.dto

data class UpdateTaskRequest(
        var name: String,
        var title: String,
        var comment: String?
)
