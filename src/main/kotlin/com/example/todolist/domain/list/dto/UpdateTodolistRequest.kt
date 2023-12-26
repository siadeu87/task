package com.example.todolist.domain.list.dto

data class UpdateTodolistRequest(
        var name: String,
        var title: String,
        var comment: String?
)
