package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


@Controller
class UploadController {
    @GetMapping("/e")
    fun index(): String {
        return "main/upload"
    }

    @PostMapping("/uploade") // //new annotation since 4.3
    fun singleFileUpload(
        @RequestParam("file") file: MultipartFile,
        redirectAttributes: RedirectAttributes
    ): String {
        if (file.isEmpty) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload")
            return "redirect:uploadStatus"
        }
        try {

            // Get the file and save it somewhere
            val bytes = file.bytes
            val path = Paths.get(UPLOADED_FOLDER + file.originalFilename)
            Files.write(path, bytes)
            redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded '" + file.originalFilename + "'"
            )
        } catch (exception: IOException) {
            redirectAttributes.addFlashAttribute(
                "message",
                "erreur le chemin est incorrect"
            )
            exception.printStackTrace()
        }catch (exception: ArithmeticException) {
            // ...
        }catch (exception: Exception) {
            // ...
        }
        return "redirect:uploadStatus"
    }

    @GetMapping("/uploadStatus")
    fun uploadStatus(): String {
        return "/main/uploadStatus"
    }

    companion object {
        //Save the uploaded file to this folder
        private const val UPLOADED_FOLDER = "C://Users//antho//OneDrive//Bureau//"
    }
}