package com.example.todolist.domain.list.repository

import com.example.todolist.domain.list.model.Todolist
import org.springframework.data.jpa.repository.JpaRepository

interface TodolistRepository: JpaRepository<Todolist, Long> {

}