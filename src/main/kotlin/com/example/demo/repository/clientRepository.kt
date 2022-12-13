package com.example.demo.repository

import com.example.demo.domain.Client
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ClientRepository : CrudRepository<Client, Long> {
    override fun deleteById(id: Long)


    fun existsClientByNameAndSurname(name :String, surname:String): Boolean

    fun existsClientByCcexpiresAndCcTypeAndCcNumberAndCvv2(ccexpires: String,ccType: String,ccNumber: String,cvv2: String ): Boolean
}
