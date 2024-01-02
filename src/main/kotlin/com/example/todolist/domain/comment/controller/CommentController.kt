package com.example.todolist.domain.comment.controller

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import com.example.todolist.domain.list.service.TodolistService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todolistAll/{id}/comments")
@RestController
class CommentController(
        private val todolistService: TodolistService
) {

    @GetMapping
    fun getComment(@PathVariable id: Long): ResponseEntity<List<CommentResponse>> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todolistService.getComment(id))
    }

    @PostMapping
    fun writeComment(
            @PathVariable id: Long,
            @RequestBody writeCommentRequest: WriteCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todolistService.writeComment(id, writeCommentRequest))
    }

    @PutMapping("/{commentId}")
    fun updateComment(
            @PathVariable id: Long,
            @PathVariable commentId: Long,
            @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse>{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todolistService.updateComment(id,commentId, updateCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
            @PathVariable id: Long,
            @PathVariable commentId: Long
    ): ResponseEntity<Unit>{
        todolistService.deleteComment(id, commentId)
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
    }
}