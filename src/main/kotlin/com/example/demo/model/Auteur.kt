package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "auteur")
class Auteur(

    @Column(name = "login", unique = true, nullable = false)
    var login: String,

    @Column(name = "firstname", nullable = false)
    var firstname: String,

    @Column(name = "lastname", nullable = false)
    var lastname: String,

    @Column(columnDefinition="TEXT")
    var description: String? = null,

    @Id @GeneratedValue var id: Long? = null)