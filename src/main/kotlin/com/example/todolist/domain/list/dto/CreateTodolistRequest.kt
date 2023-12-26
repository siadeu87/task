package com.example.todolist.domain.list.dto

data class CreateTodolistRequest(
        var name: String,
        var title: String,
        var comment: String?
)
