package com.example.demo.service

import java.lang.Math.abs
import java.time.LocalDate
import java.time.Period

/**
 * Cette fonction vérifie si une personne est âgée de 18 à 88 ans.
 *
 * @param dateNaissance La date de naissance sous forme de chaîne (ex: "MM/DD/YYYY")
 * @return 'true' si la personne est âgée de 18 à 88 ans, 'false' sinon
 */
fun getAge(dateNaissance: String): Boolean {
    // Extraction du mois, du jour et de l'année de la chaîne dateNaissance
    val (month, day, year) = dateNaissance.split("/")

    // Calcul de l'âge en années
    val age = Period.between(
        LocalDate.of(year.toInt(), month.toInt(), day.toInt()),
        LocalDate.now()
    ).years

    // Retourne 'true' si l'âge est compris entre 18 et 88 ans, sinon 'false'
    return age in 18..88
}

/**
 * Cette fonction compare si la valeur en pieds et pouces est égale à la valeur en centimètres.
 *
 * @param feetInches La mesure en pieds et pouces sous forme de chaîne (ex: "5ft 10in")
 * @param centimeters La mesure en centimètres sous forme de chaîne (ex: "178cm")
 * @return 'true' si les deux mesures sont approximativement égales, 'false' sinon
 */
fun isFeetInchesEqualCm(feetInches: String, centimeters: String): Boolean {
    // Extraction des pieds et pouces de la chaîne feetInches, suppression du dernier caractère et conversion en entier
    val (feet, inches) = feetInches.split(" ").map { it.dropLast(1).toInt() }

    // Conversion des pieds et pouces en centimètres
    val feetInchesToCm = (feet * 30.48) + (inches * 2.54)

    // Retourne 'true' si la différence entre les deux mesures est inférieure à 1,25 cm, sinon 'false'
    return abs(feetInchesToCm - centimeters.toDouble()) < 1.25
}