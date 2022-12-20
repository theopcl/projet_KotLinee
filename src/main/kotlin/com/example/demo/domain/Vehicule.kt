package com.example.demo.domain

import javax.persistence.*

@Entity
@Table(name = "Vehicule")
class Vehicule(

    @Column(name = "Annee", unique = false, nullable = false)
    var annee: String,

    @Column(name = "modele" ,unique = false, nullable = false)
    var modele: String,

    @Id @GeneratedValue var id: Long? = null)