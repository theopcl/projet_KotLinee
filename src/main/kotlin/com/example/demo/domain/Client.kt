package com.example.demo.domain

import javax.persistence.*

@Entity
@Table(name = "Client")
class Client(

    @Column(name = "Gender", unique = false, nullable = false)
    var gender: String,

    @Column(name = "Title" ,unique = false, nullable = false)
    var title: String,

    @Column(name = "GivenName",unique = false, nullable = false)
    var name: String,

    @Column(name = "Surname",unique = false, nullable = false)
    var surname: String,

    @Column(name = "EmailAddress",unique = false, nullable = false)
    var email: String,

    @Column(name = "Birthday",unique = false, nullable = false)
    var birthday: String,

    @Column(name = "TelephoneNumber",unique = false, nullable = false)
    var telephoneNumber: String,

    @Column(name = "CCType",unique = false, nullable = false)
    var ccType: String,

    @Column(name = "CCNumber",unique = false, nullable = false)
    var ccNumber: String,

    @Column(name = "CVV2",unique = false, nullable = false)
    var cvv2: String,

    @Column(name = "CCExpires",unique = false, nullable = false)
    var ccexpires: String,

    @Column(name = "StreetAddress",unique = false, nullable = false)
    var streetAddress: String,

    @Column(name = "City",unique = false, nullable = false)
    var city: String,

    @Column(name = "State", nullable = false)
    var state: String,

    @Column(name = "ZipCode", nullable = false)
    var zipCode: String,

    @Column(name = "FeetInches", nullable = false)
    var feetInches: String,

    @Column(name = "Centimeters", nullable = false)
    var centimeters: String,

    @Column(name = "Country", nullable = false)
    var country: String,

    @Column(name = "Pounds",nullable = false)
    var pounds: String,

    @Column(name = "Kilograms", nullable = false)
    var kilograms: String,

    @Column(name = "Vehicle", nullable = false)
    var vehicle: String,

    @Column(name = "Latitude", nullable = false)
    var latitude: String,

    @Column(name = "Longitude", nullable = false)
    var longitude: String,

    @Column(name = "Contrainte", nullable = false)
    var contrainte: String,


    @Id @GeneratedValue var id: Long? = null)