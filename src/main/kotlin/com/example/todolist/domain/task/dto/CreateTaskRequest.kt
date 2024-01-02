package com.example.todolist.domain.task.dto

data class CreateTaskRequest(
        var name: String,
        var title: String,
        var comment: String?
)
