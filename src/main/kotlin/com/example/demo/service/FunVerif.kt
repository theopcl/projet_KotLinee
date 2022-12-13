package com.example.demo.service

import java.lang.Math.abs
import java.time.LocalDate
import java.time.Period

fun getAge(dateNaissance:String):Boolean {
    val delimiter = "/"
    val birthday = dateNaissance
    val ageSplittedTab = birthday.split(delimiter)
    val age = Period.between(
        LocalDate.of(ageSplittedTab[2].toInt(), ageSplittedTab[0].toInt(), ageSplittedTab[1].toInt()),
        LocalDate.now()
    ).years
    if (age in 18..88) {
        return true
    }
    return false
}


fun isFeetInchesEqualCm(feetInches: String, centimeters: String): Boolean {
    val words: List<String> = feetInches.split(" ")
    var pied = words[0].substring(0, words[0].length - 1).toInt()
    var pouce = words[1].substring(0, words[1].length - 1).toInt()

    var feetInchesToCm = ((pied * 30.48) + (pouce * 2.54))
    var feetInchesInCm =feetInchesToCm

    if (abs(feetInchesInCm-centimeters.toDouble())<1.25) {
        return true
    }
    return false
}