package com.ammiageu.literalura.service;

import com.ammiageu.literalura.model.Book;
import java.util.List;

public interface GutendexService {
    List<Book> searchBooks(String query);
}
