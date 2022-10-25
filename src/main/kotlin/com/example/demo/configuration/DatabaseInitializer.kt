package com.example.demo.configuration

import com.example.demo.model.Article
import com.example.demo.model.Auteur
import com.example.demo.repository.ArticleRepository
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(value = 1)
@Component
class DatabaseInitializer @Autowired constructor(
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        databaseInitializer()
    }

    fun databaseInitializer() {
        val countUser = userRepository.count();

        if (countUser > 0) return

        val bob = userRepository.save(Auteur("solid", "Bob", "Martin"))
        val meyer = userRepository.save(Auteur("meyer", "Bertrand", "Meyer"))
        val barbara = userRepository.save(Auteur("barbara", "Barbara", "Liskov"))
        val gof = userRepository.save(Auteur("gof", "GoF", "Design Patterns"))

        articleRepository.save(
            Article(
                title = "S de SOLID",
                headline = "Responsabilité unique (Single Responsibility)",
                content = "Une classe, une fonction ou une méthode doit avoir une et une seule responsabilité",
                author = bob
            )
        )

        articleRepository.save(
            Article(
                title = "O de SOLD",
                headline = "Ouvert/fermé (Open/closed principle)",
                content = "Une entité applicative (classe, fonction, module ...) doit être fermée à la modification directe mais ouverte à l'extension",
                author = meyer
            )
        )

        articleRepository.save(
            Article(
                title = "L de SOLID",
                headline = "Substitution de Liskov (Liskov substitution principle)",
                content = "Une instance de type T doit pouvoir être remplacée par une instance de type G, tel que G sous-type de T, sans que cela ne modifie la cohérence du programme",
                author = barbara
            )
        )

        articleRepository.save(
            Article(
                title = "I de SOLID",
                headline = "Ségrégation des interfaces (Interface segregation principle)",
                content = "Préférer plusieurs interfaces spécifiques pour chaque client plutôt qu'une seule interface générale",
                author = bob
            )
        )

        articleRepository.save(
            Article(
                title = "D de SOLID",
                headline = "Inversion des dépendances (Dependency inversion principle)",
                content = "Il faut dépendre des abstractions, pas des implémentations",
                author = gof
            )
        )
    }
}


