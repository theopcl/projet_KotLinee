package com.example.demo.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class clientDTO(

    @field:NotBlank
    @Size(min=3, max=15)
    val gender: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val title: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val name: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val surname: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val email: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val birthday: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val telephoneNumber: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val ccType: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val ccNumber: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val cvv2: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val streetAddress: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val city: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val state: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val zipCode: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val feetInches: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val centimeters: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val country: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val pounds: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val kilograms: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val vehicle: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val latitude: String = "",

    @field:NotBlank
    @Size(min=3, max=15)
    val longitude: String = "",


    val id: Long? = null
)