package com.example.demo.controller

import com.example.demo.repository.ArticleRepository
import com.example.demo.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
class ArticleController @Autowired constructor(private val articleRepository: ArticleRepository){

    @GetMapping("/articles")
    fun index(model: Model): String {
        model["title"] = "Les articles"
        model["articles"] = articleRepository.findAllByOrderByTitleDesc()
        return "article/index"
    }
    @GetMapping("/details")
    fun details(model: Model, request: HttpServletRequest, response: HttpServletResponse): String {
        val to = request.getParameter("id") ?: ""
        val id = to.toLong()
        model["title"] = "Les details"
        model["articles"] = articleRepository.findById(id).get()
        return "details/index"
    }

}