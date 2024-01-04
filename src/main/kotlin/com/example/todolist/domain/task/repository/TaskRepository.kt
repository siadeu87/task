package com.example.todolist.domain.task.repository

import com.example.todolist.domain.task.model.Task
import org.springframework.data.jpa.repository.JpaRepository


interface TaskRepository: JpaRepository<Task, Long> {

}