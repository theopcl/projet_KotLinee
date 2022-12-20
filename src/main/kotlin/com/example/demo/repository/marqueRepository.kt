package com.example.demo.repository


import com.example.demo.domain.Marque
import org.springframework.data.repository.CrudRepository

interface MarqueRepository : CrudRepository<Marque, Long> {

    fun existsMarqueByMarque(marque :String): Boolean

}
