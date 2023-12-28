package com.example.todolist.domain.comment.controller

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.comment.dto.UpdateCommentRequest
import com.example.todolist.domain.comment.dto.WriteCommentRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todolistAll/{id}/comment")
@RestController
class CommentController {

    @GetMapping
    fun getComment(@PathVariable id: Long): ResponseEntity<List<CommentResponse>> {
        TODO()
    }

    @PostMapping
    fun writeComment(
            @PathVariable id: Long,
            @RequestBody writeCommentRequest: WriteCommentRequest
    ): ResponseEntity<CommentResponse> {
        TODO()
    }

    @PutMapping("/{commentId}")
    fun updateComment(
            @PathVariable id: Long,
            @PathVariable commentId: Long,
            @RequestBody updateCommentRequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse>{
        TODO()
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
            @PathVariable id: Long,
            @PathVariable commentId: Long
    ): ResponseEntity<Unit>{
        TODO()
    }
}