package com.example.demo
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.context.annotation.Bean
import org.springframework.util.unit.DataSize
import javax.servlet.MultipartConfigElement

@ServletComponentScan
@SpringBootApplication
class SpringBootWebApplication {

    @Bean
    fun multipartConfigElement(): MultipartConfigElement? {
        val factory = MultipartConfigFactory()
        factory.setMaxFileSize(DataSize.ofBytes(512000000L))
        factory.setMaxRequestSize(DataSize.ofBytes(512000000L))
        return factory.createMultipartConfig()
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringBootWebApplication::class.java, *args)
        }
    }
}


class TomcatEmbeddedServletContainerFactory {
    fun addConnectorCustomizers(tomcatConnectorCustomizer: Any) {
        TODO("Not yet implemented")
    }

}