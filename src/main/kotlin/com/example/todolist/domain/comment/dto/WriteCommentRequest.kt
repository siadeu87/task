package com.example.todolist.domain.comment.dto

data class WriteCommentRequest(
        val name: String,
        val password: String,
        val comment: String
)
