package com.example.todolist.domain.list.service

import com.example.todolist.domain.exception.ModelNotFoundException
import com.example.todolist.domain.list.dto.CreateTodolistRequest
import com.example.todolist.domain.list.dto.TodolistResponse
import com.example.todolist.domain.list.dto.UpdateTodolistRequest
import com.example.todolist.domain.list.model.Todolist
import com.example.todolist.domain.list.model.toResponse
import com.example.todolist.domain.list.repository.TodolistRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodolistServiceImpl(
        private val todolistRepository: TodolistRepository
): TodolistService{
    override fun getTodolistAll(): List<TodolistResponse> {
        return todolistRepository.findAll().map { it.toResponse() }
    }

    override fun getTodolist(id: Long): TodolistResponse {
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist",id)
        return todolist.toResponse()
    }

    @Transactional
    override fun createTodolist(request: CreateTodolistRequest): TodolistResponse {
        return todolistRepository.save(
                Todolist(
                        name = request.name,
                        title = request.title,
                        comment = request.comment,
                )
        ).toResponse()
    }

    @Transactional
    override fun updateTodolist(id: Long, request: UpdateTodolistRequest): TodolistResponse {
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        val (name, title, comment) = request

        todolist.name = name
        todolist.title = title
        todolist.comment = comment

        return todolistRepository.save(todolist).toResponse()
    }

    @Transactional
    override fun deleteTodolist(id: Long){
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        return todolistRepository.delete(todolist)
    }

}