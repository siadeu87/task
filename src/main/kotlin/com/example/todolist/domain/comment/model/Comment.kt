package com.example.todolist.domain.comment.model

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.task.model.Task
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment(

        @Column(name = "name")
        var name: String,

        @Column(name = "password")
        var password: String,

        @Column(name = "comment")
        var comment: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "task_id")
        var task: Task
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    constructor() : this("","","",Task())
}

fun Comment.toResponse(): CommentResponse{
    return CommentResponse(
            id = id!!,
            name = name,
            comment = comment
    )
}