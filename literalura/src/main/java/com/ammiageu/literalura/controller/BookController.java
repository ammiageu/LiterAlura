package com.ammiageu.literalura.controller;

import com.ammiageu.literalura.model.Book;
import com.ammiageu.literalura.service.GutendexService;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private final GutendexService gutendexService;

    public BookController(GutendexService gutendexService) {
        this.gutendexService = gutendexService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del libro a buscar:");
        String query = scanner.nextLine().trim();

        List<Book> books = gutendexService.searchBooks(query);
        if (!books.isEmpty()) {
            System.out.println("Resultados encontrados para '" + query + "':");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No se encontraron libros para la consulta: " + query);
        }
    }
}
