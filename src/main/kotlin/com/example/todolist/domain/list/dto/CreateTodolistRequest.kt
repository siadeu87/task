package com.example.todolist.domain.list.dto

data class CreateTodolistRequest(
        var user: String,
        var title: String,
        var comment: String?
)
