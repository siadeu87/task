package com.example.todolist.domain.task.service

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import com.example.todolist.domain.task.dto.CreateTaskRequest
import com.example.todolist.domain.task.dto.TaskResponse
import com.example.todolist.domain.task.dto.UpdateTaskRequest

interface TaskService {
    fun getTaskList() : List<TaskResponse>

    fun getTask(id: Long): TaskResponse

    fun createTask(request: CreateTaskRequest): TaskResponse

    fun updateTask(id: Long, request: UpdateTaskRequest): TaskResponse

    fun deleteTask(id: Long)

    fun getComment(id: Long): List<CommentResponse>

    fun updateComment(id: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun writeComment(id: Long, request: WriteCommentRequest): CommentResponse

    fun deleteComment(id: Long, commentId: Long)
}