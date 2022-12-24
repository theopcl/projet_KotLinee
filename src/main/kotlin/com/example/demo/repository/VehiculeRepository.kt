package com.example.demo.repository
import com.example.demo.domain.Vehicule
import org.springframework.data.repository.CrudRepository

interface VehiculeRepository : CrudRepository<Vehicule, Long> {
    fun existsVehiculeByAnneeAndModele(annee :String,modele :String): Boolean
}
