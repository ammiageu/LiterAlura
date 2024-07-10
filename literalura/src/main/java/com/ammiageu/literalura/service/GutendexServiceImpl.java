package com.ammiageu.literalura.service;

import com.ammiageu.literalura.model.Author;
import com.ammiageu.literalura.model.Book;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexServiceImpl implements GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books/";

    @Override
    public List<Book> searchBooks(String title) {
        String url = BASE_URL + "?search=" + title.replace(" ", "%20");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
        List<Book> books = new ArrayList<>();
        jsonObject.getAsJsonArray("results").forEach(bookJsonElement -> {
            JsonObject bookJsonObject = bookJsonElement.getAsJsonObject();
            String bookTitle = bookJsonObject.get("title").getAsString();
            String language = bookJsonObject.getAsJsonArray("languages").get(0).getAsString();
            int downloadCount = bookJsonObject.get("download_count").getAsInt();
            JsonObject authorJsonObject = bookJsonObject.getAsJsonArray("authors").get(0).getAsJsonObject();
            String authorName = authorJsonObject.get("name").getAsString();
            int birthYear = authorJsonObject.get("birth_year").getAsInt();
            int deathYear = authorJsonObject.get("death_year").getAsInt();
            Author author = new Author(authorName, birthYear, deathYear);
            books.add(new Book(bookTitle, author, language, downloadCount));
        });

        return books;
    }
}
