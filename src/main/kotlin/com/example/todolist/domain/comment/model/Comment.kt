package com.example.todolist.domain.comment.model

import com.example.todolist.domain.comment.dto.CommentResponse
import com.example.todolist.domain.list.model.Todolist
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
        @JoinColumn(name = "todolist_id")
        var todolist: Todolist
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    constructor() : this("","","",Todolist())
}

fun Comment.toResponse(): CommentResponse{
    return CommentResponse(
            id = id!!,
            name = name,
            comment = comment
    )
}