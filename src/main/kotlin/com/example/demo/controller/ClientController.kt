package com.example.demo.controller

import com.example.demo.domain.Client
import com.example.demo.repository.ClientRepository
import com.example.demo.service.getAge
import com.example.demo.service.isFeetInchesEqualCm
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.io.Reader
import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Paths
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
class ClientController @Autowired constructor(private val clientRepository: ClientRepository) {

    @GetMapping("/")
    fun index(): String {
        return "main/upload"
    }

    @PostMapping("/upload") // //new annotation since 4.3

    fun file(@RequestParam("file") file: MultipartFile, redirectAttributes: RedirectAttributes): String {
        if (file.isEmpty) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload")
            return "redirect:uploadStatus"
        }

        try {
            val bytes = file.bytes
            val path = Paths.get("csvRepository//" + file.originalFilename)
            Files.write(path, bytes)


            val fileName = File("csvRepository//" + file.originalFilename)
            val `in`: Reader = FileReader(fileName)
            val records: Iterable<CSVRecord> = CSVFormat.EXCEL.withHeader().parse(`in`)
            for (record in records) {
                val gender = record["Gender"]
                val title = record["Title"]
                val name = record["GivenName"]
                val surname = record["Surname"]
                val email = record["EmailAddress"]
                val birthday = record["Birthday"]
                val telephoneNumber = record["TelephoneNumber"]
                val ccType = record["CCType"]
                val CCNumber = record["CCNumber"]
                val CVV2 = record["CVV2"]
                val CCExpires = record["CCExpires"]
                val streetAddress = record["StreetAddress"]
                val city = record["City"]
                val state = record["State"]
                val zipCode = record["ZipCode"]
                val feetInches = record["FeetInches"]
                val centimeters = record["Centimeters"]
                val country = record["Country"]
                val pounds = record["Pounds"]
                val kilograms = record["Kilograms"]
                val vehicule = record["Vehicle"]
                val latitude = record["Latitude"]
                val longitude = record["Longitude"]
                var contrainte = "Correct"

                var isContrainte = true

                if (isFeetInchesEqualCm(feetInches, centimeters) && getAge(birthday) && !clientRepository.existsClientByCcexpiresAndCcTypeAndCcNumberAndCvv2(CCExpires,ccType,CCNumber, CVV2)) {
                    isContrainte = false
                }

                if (isContrainte) {
                    contrainte = "Incorrect"
                }

                if (!clientRepository.existsClientByNameAndSurname(name, surname)) {
                    clientRepository.save(
                        Client(
                            gender,
                            title,
                            name,
                            surname,
                            email,
                            birthday,
                            telephoneNumber,
                            ccType,
                            CCNumber,
                            CVV2,
                            CCExpires,
                            streetAddress,
                            city,
                            state,
                            zipCode,
                            feetInches,
                            centimeters,
                            country,
                            pounds,
                            kilograms,
                            vehicule,
                            latitude,
                            longitude,
                            contrainte
                        )
                    )
                }

            }
            redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded '" + fileName.absolutePath + "'"
            )
        } catch (exception: IOException) {
            redirectAttributes.addFlashAttribute(
                "message",
                "erreur le chemin est incorrect"
            )
            exception.printStackTrace()
        } catch (exception: Exception) {
            redirectAttributes.addFlashAttribute(
                "message",
                "Le fichier n'est pas valide !"
            )
            exception.printStackTrace()
        } catch (exception: IllegalArgumentException) {
            redirectAttributes.addFlashAttribute(
                "message",
                "Le fichier n'est pas valide"
            )
            exception.printStackTrace()
        }
        return "redirect:uploadStatus"
    }


    @GetMapping("/client")
    fun client(model: Model): String {
        model["title"] = "Client"
        model["clients"] = clientRepository.findAll()
        return "main/client"
    }

    @GetMapping("/supp")
    fun suppClient(model: Model, request: HttpServletRequest, responce: HttpServletResponse): String {
        var id = request.getParameter("id").toLong()
        clientRepository.deleteById(id)
        return "redirect:/client"
    }
}