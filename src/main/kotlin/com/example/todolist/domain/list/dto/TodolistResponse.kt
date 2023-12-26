package com.example.todolist.domain.list.dto

data class TodolistResponse(
        val id: Long,
        val user: String,
        val title: String,
        val comment: String?,
        val time: Int
)
