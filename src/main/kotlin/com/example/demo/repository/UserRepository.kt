package com.example.demo.repository

import com.example.demo.model.Auteur
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<Auteur, Long> {
    fun findByLogin(login: String): Auteur?
}

