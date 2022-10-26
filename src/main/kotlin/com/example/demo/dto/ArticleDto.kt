package com.example.demo.dto

data class ArticleDto(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: PersonDto,
    val addedAt: String,
    var id: Long? = null
    )
