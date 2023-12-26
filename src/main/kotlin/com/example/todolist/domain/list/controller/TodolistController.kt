package com.example.todolist.domain.list.controller

import com.example.todolist.domain.list.dto.CreateTodolistRequest
import com.example.todolist.domain.list.dto.TodolistResponse
import com.example.todolist.domain.list.dto.UpdateTodolistRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todolist")
@RestController
class TodolistController {

    @GetMapping
    fun getTodolistAll(): ResponseEntity<TodolistResponse>{
        TODO()
    }

    @GetMapping("/{id}")
    fun getTodolist(@PathVariable id: Long): ResponseEntity<TodolistResponse>{
        TODO()
    }

    @PostMapping
    fun createTodolist(@RequestBody createToDoListRequest: CreateTodolistRequest): ResponseEntity<TodolistResponse>{
        TODO()
    }

    @PostMapping("/{id}")
    fun updateTodolist(@PathVariable id: String, @RequestBody updateToDoListRequest: UpdateTodolistRequest): ResponseEntity<TodolistResponse>{
        TODO()
    }

    @DeleteMapping("/{id}")
    fun deleteTodolist(@PathVariable id: String): ResponseEntity<TodolistResponse>{
        TODO()
    }

}