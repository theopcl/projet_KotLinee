package com.example.demo.dto

import com.example.demo.model.User

data class ArticleDto(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: UserDto,
    val addedAt: String)
