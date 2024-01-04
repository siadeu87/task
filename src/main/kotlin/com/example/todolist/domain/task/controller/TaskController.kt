package com.example.todolist.domain.task.controller

import com.example.todolist.domain.task.dto.CreateTaskRequest
import com.example.todolist.domain.task.dto.TaskAndCommentResponse
import com.example.todolist.domain.task.dto.TaskResponse
import com.example.todolist.domain.task.dto.UpdateTaskRequest
import com.example.todolist.domain.task.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/tasks")
@RestController
class TaskController(
        private val taskService: TaskService
) {

    @GetMapping
    fun getTaskList(): ResponseEntity<List<TaskResponse>>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.getTaskList())
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): ResponseEntity<TaskAndCommentResponse>{
        val task = taskService.getTask(id)
        val comment = taskService.getComment(id)

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(TaskAndCommentResponse(task,comment))
    }

    @PostMapping
    fun createTask(@RequestBody createToDoListRequest: CreateTaskRequest): ResponseEntity<TaskResponse>{
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.createTask(createToDoListRequest))
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody updateToDoListRequest: UpdateTaskRequest): ResponseEntity<TaskResponse>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.updateTask(id, updateToDoListRequest))
    }

    @PatchMapping("/{id}/check")
    fun checkTask(@PathVariable id: Long): TaskResponse {
        return taskService.checkTask(id)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<Unit>{
        taskService.deleteTask(id)
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
    }
}