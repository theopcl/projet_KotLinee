package com.example.demo.dto

data class PersonDto(
    val name: String,
    val lastname: String,
    val description: String?,
    var id: Long? = null
)
