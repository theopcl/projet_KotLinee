package com.example.demo

import com.example.demo.dto.ArticleDto
import com.example.demo.dto.AuteurDto
import com.example.demo.model.Article
import com.example.demo.model.Auteur
import java.util.*

fun String.toSlug() = lowercase(Locale.getDefault())
    .replace("\n", " ")
    .replace("[^a-z\\d\\s]".toRegex(), " ")
    .split(" ")
    .joinToString("-")
    .replace("-+".toRegex(), "-")

fun Article.toDto() = ArticleDto(
    this.slug,
    this.title,
    this.headline,
    this.content,
    this.author.toDto(),
    this.addedAt.toString())

fun Auteur.toDto() = AuteurDto(
    this.firstname,
    this.lastname,
    this.description
)