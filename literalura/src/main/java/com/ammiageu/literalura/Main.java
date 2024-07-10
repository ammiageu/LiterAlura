package com.ammiageu.literalura;

import com.ammiageu.literalura.service.GutendexService;
import com.ammiageu.literalura.service.GutendexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private GutendexService gutendexService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro:");
        String title = scanner.nextLine();
        var books = gutendexService.searchBooks(title);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            books.forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Autor: " + book.getAuthor().getName());
                System.out.println("Idioma: " + book.getLanguage());
                System.out.println("Número de Descargas: " + book.getDownloadCount());
                System.out.println("-------------------------");
            });
        }
    }
}
