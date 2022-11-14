package com.example.demo.controller

import com.example.demo.repository.ArticleRepository
import com.example.demo.repository.PersonRepository
import com.example.demo.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuteursController @Autowired constructor(private val personRepository: PersonRepository){

    @GetMapping("/Auteurs")
    fun index(model: Model): String {
        model["title"] = "Les auteurs"
        model["articles"] = personRepository.findAll()
        return "Auteurs/index"
    }

}