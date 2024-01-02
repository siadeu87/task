package com.example.todolist.domain.list.service

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import com.example.todolist.domain.list.dto.CreateTodolistRequest
import com.example.todolist.domain.list.dto.TodolistResponse
import com.example.todolist.domain.list.dto.UpdateTodolistRequest

interface TodolistService {
    fun getTodolistAll() : List<TodolistResponse>

    fun getTodolist(id: Long): TodolistResponse

    fun createTodolist(request: CreateTodolistRequest): TodolistResponse

    fun updateTodolist(id: Long, request: UpdateTodolistRequest): TodolistResponse

    fun deleteTodolist(id: Long)

    fun getComment(id: Long): List<CommentResponse>

    fun updateComment(id: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun writeComment(id: Long, request: WriteCommentRequest): CommentResponse

    fun deleteComment(id: Long, commentId: Long)
}