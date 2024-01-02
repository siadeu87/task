package com.example.todolist.domain.list.model

import com.example.todolist.domain.comment.model.Comment
import com.example.todolist.domain.list.dto.TodolistResponse
import jakarta.persistence.Column
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "todolist")
class Todolist(

        @Column(name = "name")
        var name: String,

        @Column(name = "title")
        var title: String,

        @Column(name = "comment")
        var comment: String?,

        @Column(name = "time")
        var time: LocalDateTime = LocalDateTime.now(),

        @OneToMany(mappedBy = "todolist", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
        var comments: MutableList<Comment> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun writeComment(comment: Comment) {
        comments.add(comment)
    }

    fun deleteComment(comment: Comment) {
        comments.remove(comment)
    }


    constructor() : this("", "", "", LocalDateTime.now())
}

fun Todolist.toResponse(): TodolistResponse{
    return TodolistResponse(
            id = id!!,
            name = name,
            title = title,
            comment = comment,
            time = time
    )
}

