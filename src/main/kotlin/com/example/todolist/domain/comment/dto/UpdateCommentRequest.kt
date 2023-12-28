package com.example.todolist.domain.comment.dto

data class UpdateCommentRequest(
        val name: String,
        val password: String,
        val comment: String
)