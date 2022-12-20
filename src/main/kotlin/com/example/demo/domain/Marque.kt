package com.example.demo.domain

import javax.persistence.*

@Entity
@Table(name = "Marque")
class Marque(

    @Column(name = "marque", unique = false, nullable = false)
    var marque: String,


    @Id @GeneratedValue var idMarque: Long? = null)