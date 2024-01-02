package com.example.todolist.domain.task.service

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import com.example.todolist.domain.comment.model.Comment
import com.example.todolist.domain.comment.model.toResponse
import com.example.todolist.domain.comment.repository.CommentRepository
import com.example.todolist.domain.exception.ModelNotFoundException
import com.example.todolist.domain.task.dto.CreateTaskRequest
import com.example.todolist.domain.task.dto.TaskResponse
import com.example.todolist.domain.task.dto.UpdateTaskRequest
import com.example.todolist.domain.task.model.Task
import com.example.todolist.domain.task.model.TaskStatus
import com.example.todolist.domain.task.model.toResponse
import com.example.todolist.domain.task.repository.TaskRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
        private val taskRepository: TaskRepository,
        private val commentRepository: CommentRepository
): TaskService{
    override fun getTaskList(): List<TaskResponse> {
        return taskRepository.findAll().map { it.toResponse() }
    }

    override fun getTask(id: Long): TaskResponse {
        val task = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Task",id)
        return task.toResponse()
    }

    @Transactional
    override fun createTask(request: CreateTaskRequest): TaskResponse {
        return taskRepository.save(
                Task(
                        name = request.name,
                        title = request.title,
                        comment = request.comment,
                        status = TaskStatus.FALSE
                )
        ).toResponse()
    }

    @Transactional
    override fun updateTask(id: Long, request: UpdateTaskRequest): TaskResponse {
        val task = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Task", id)
        val (name, title, detail) = request

        task.name = name
        task.title = title
        task.comment = detail

        return taskRepository.save(task).toResponse()
    }

    @Transactional
    override fun checkTask(id: Long): TaskResponse {
        val task = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Task", id)
        task.status = TaskStatus.TRUE

        return taskRepository.save(task).toResponse()
    }

    @Transactional
    override fun deleteTask(id: Long){
        val todolist = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        return taskRepository.delete(todolist)
    }

    override fun getComment(id: Long): List<CommentResponse> {
        val todolist = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Todolist", id)
        return todolist.comments.map { it.toResponse() }
    }

    @Transactional
    override fun updateComment(id: Long, commentId: Long, request: UpdateCommentRequest, verifyName: String, verifyPassword: String): CommentResponse {
        val comments = commentRepository.findByTaskIdAndId(id, commentId) ?: throw ModelNotFoundException("Comment", commentId)

        if(comments.password != verifyPassword || comments.name != verifyName){
            throw ModelNotFoundException("이름 또는 비밀번호가 일치하지 않습니다.", commentId)
        }

        val (name,password,comment) = request
        comments.name = name
        comments.password = password
        comments.comment = comment

        return commentRepository.save(comments).toResponse()
    }

    @Transactional
    override fun writeComment(id: Long, request: WriteCommentRequest): CommentResponse {
        val task = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Task", id)
        val comment = Comment(
                name = request.name,
                password = request.password,
                comment = request.comment,
                task = task
        )
        task.writeComment(comment)
        taskRepository.save(task)

        return comment.toResponse()
    }

    @Transactional
    override fun deleteComment(id: Long, commentId: Long, verifyName: String, verifyPassword: String) {
        val task = taskRepository.findByIdOrNull(id) ?: throw ModelNotFoundException("Task", id)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("Comment", commentId)

        if(comment.password != verifyPassword || comment.name != verifyName){
            throw ModelNotFoundException("이름 또는 비밀번호가 일치하지 않습니다.", commentId)
        }
        task.deleteComment(comment)
        taskRepository.save(task)
    }

}