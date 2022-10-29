package com.example.demo.dto

data class ArticleDto(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val addedAt: String,
    val authorId : Long?,
    var id: Long? = null
    )
