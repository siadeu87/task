package com.example.todolist.domain.task.model

import com.example.todolist.domain.comment.model.Comment
import com.example.todolist.domain.task.dto.TaskResponse
import jakarta.persistence.Column
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "task")
class Task(

        @Column(name = "name")
        var name: String,

        @Column(name = "title")
        var title: String,

        @Column(name = "comment")
        var comment: String?,

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        var status: TaskStatus,

        @Column(name = "time")
        var time: LocalDateTime = LocalDateTime.now(),

        @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
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


    constructor() : this("", "", "", TaskStatus.FALSE ,LocalDateTime.now())
}

fun Task.toResponse(): TaskResponse{
    return TaskResponse(
            id = id!!,
            name = name,
            title = title,
            comment = comment,
            status = status.name,
            time = time
    )
}

