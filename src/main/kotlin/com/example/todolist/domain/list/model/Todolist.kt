package com.example.todolist.domain.list.model

import jakarta.persistence.Column
import jakarta.persistence.*

@Entity
@Table(name = "todolist")
class Todolist (

    @Column(name = "name")
    var name: String,

    @Column(name = "title")
    var title: String,

    @Column(name = "comment")
    var comment: String?,
)

