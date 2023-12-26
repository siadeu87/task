package com.example.todolist.domain.list.service

import com.example.todolist.domain.list.dto.CreateTodolistRequest
import com.example.todolist.domain.list.dto.TodolistResponse
import com.example.todolist.domain.list.dto.UpdateTodolistRequest

interface TodolistService {
    fun getTodolistAll() : List<TodolistResponse>

    fun getTodolist(id: Long): TodolistResponse

    fun createTodolist(request: CreateTodolistRequest): TodolistResponse

    fun updateTodolist(id: Long, request: UpdateTodolistRequest): TodolistResponse

    fun deleteTodolist(id: Long): TodolistResponse
}