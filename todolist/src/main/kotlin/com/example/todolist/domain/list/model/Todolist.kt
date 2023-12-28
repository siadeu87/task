package com.example.todolist.domain.list.model

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
        var time: LocalDateTime = LocalDateTime.now()


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

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

