package com.example.todolist.domain.list.dto

data class UpdateTodolistRequest(
        var user: String,
        var title: String,
        var comment: String?
)
