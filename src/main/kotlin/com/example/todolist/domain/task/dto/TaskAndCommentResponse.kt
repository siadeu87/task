package com.example.todolist.domain.task.dto

import com.example.todolist.domain.comment.dto.CommentResponse

data class TaskAndCommentResponse(
        val task: TaskResponse,
        val comment: List<CommentResponse>
)
