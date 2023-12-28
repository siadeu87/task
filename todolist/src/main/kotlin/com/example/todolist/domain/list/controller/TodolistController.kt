package com.example.todolist.domain.list.controller

import com.example.todolist.domain.list.dto.CreateTodolistRequest
import com.example.todolist.domain.list.dto.TodolistResponse
import com.example.todolist.domain.list.dto.UpdateTodolistRequest
import com.example.todolist.domain.list.service.TodolistService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todolistAll")
@RestController
class TodolistController(
        private val todolistService: TodolistService
) {

    @GetMapping
    fun getTodolistAll(): ResponseEntity<List<TodolistResponse>>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todolistService.getTodolistAll())
    }

    @GetMapping("/{id}")
    fun getTodolist(@PathVariable id: Long): ResponseEntity<TodolistResponse>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todolistService.getTodolist(id))
    }

    @PostMapping
    fun createTodolist(@RequestBody createToDoListRequest: CreateTodolistRequest): ResponseEntity<TodolistResponse>{
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todolistService.createTodolist(createToDoListRequest))
    }

    @PutMapping("/{id}")
    fun updateTodolist(@PathVariable id: Long, @RequestBody updateToDoListRequest: UpdateTodolistRequest): ResponseEntity<TodolistResponse>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todolistService.updateTodolist(id, updateToDoListRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteTodolist(@PathVariable id: Long): ResponseEntity<Unit>{
        todolistService.deleteTodolist(id)
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
    }
}