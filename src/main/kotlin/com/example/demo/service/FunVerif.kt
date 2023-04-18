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
    // Utilisation de la méthode 'split' pour diviser la chaîne dateNaissance en plusieurs éléments
    // en utilisant le caractère '/' comme séparateur.
    // Les éléments sont ensuite stockés dans les variables 'month', 'day' et 'year'.
    val (month, day, year) = dateNaissance.split("/")



    //    Les variables 'year', 'month' et 'day' sont converties en entier avec 'toInt()' et passées à la méthode 'of'.
    // 3. Utilisation de la méthode 'between()' de la classe 'Period' pour calculer la période entre
    //    la date de naissance et la date actuelle.
    // 4. Accès à la propriété 'years' de l'objet 'Period' pour obtenir l'âge en années.
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
    // Utilisation de la méthode 'split' pour diviser la chaîne 'feetInches' en deux éléments
    // en utilisant le caractère ' ' (espace) comme séparateur.
    // Puis, la méthode 'map' est utilisée pour transformer chaque élément de la liste.
    val (feet, inches) = feetInches.split(" ").map {
        // Utilisation de 'it' pour faire référence à l'élément courant de la liste.
        // La méthode 'dropLast' est utilisée pour supprimer le dernier caractère de la chaîne 'it'.
        // Enfin, la chaîne résultante est convertie en entier avec 'toInt()'.
        it.dropLast(1).toInt()  }

    // Conversion des pieds et pouces en centimètres
    val feetInchesToCm = (feet * 30.48) + (inches * 2.54)

    // Retourne 'true' si la différence entre les deux mesures est inférieure à 1,25 cm, sinon 'false'
    return abs(feetInchesToCm - centimeters.toDouble()) < 1.25
}
fun main(vehicle :String) {

    var vehicule = vehicle
    var delimiter = " "

    val parts = vehicule.split(delimiter)

    print(parts)
}