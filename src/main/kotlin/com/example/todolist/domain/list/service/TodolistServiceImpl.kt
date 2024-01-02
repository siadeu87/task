package com.example.todolist.domain.list.service

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import com.example.todolist.domain.comment.model.Comment
import com.example.todolist.domain.comment.model.toResponse
import com.example.todolist.domain.comment.repository.CommentRepository
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
        private val todolistRepository: TodolistRepository,
        private val commentRepository: CommentRepository
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
        val (name, title, detail) = request

        todolist.name = name
        todolist.title = title
        todolist.comment = detail

        return todolistRepository.save(todolist).toResponse()
    }

    @Transactional
    override fun deleteTodolist(id: Long){
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        return todolistRepository.delete(todolist)
    }

    override fun getComment(id: Long): List<CommentResponse> {
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw  ModelNotFoundException("Todolist", id)
        return todolist.comments.map { it.toResponse() }
    }

    @Transactional
    override fun updateComment(id: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val comments = commentRepository.findByTodolistIdAndId(id, commentId) ?: throw ModelNotFoundException("Comment", commentId)
        val (name, password,comment) = request
        comments.name = name
        comments.password = password
        comments.comment = comment

        return commentRepository.save(comments).toResponse()
    }

    @Transactional
    override fun writeComment(id: Long, request: WriteCommentRequest): CommentResponse {
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        val comment = Comment(
                name = request.name,
                password = request.password,
                comment = request.comment,
                todolist = todolist
        )
        todolist.writeComment(comment)
        todolistRepository.save(todolist)

        return comment.toResponse()
    }

    @Transactional
    override fun deleteComment(id: Long, commentId: Long) {
        val todolist = todolistRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        todolist.deleteComment(comment)
        todolistRepository.save(todolist)
    }

}