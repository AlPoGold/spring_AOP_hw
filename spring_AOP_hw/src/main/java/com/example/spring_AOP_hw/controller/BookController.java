package com.example.spring_AOP_hw.controller;


import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class BookController {

    private BookService service;


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return service.getBookById(id);
    }
}
