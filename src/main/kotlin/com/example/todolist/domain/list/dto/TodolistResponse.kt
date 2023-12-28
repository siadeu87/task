package com.example.todolist.domain.list.dto

import java.time.LocalDateTime

data class TodolistResponse(
        val id: Long,
        val name: String,
        val title: String,
        val comment: String?,
        val time: LocalDateTime
)
