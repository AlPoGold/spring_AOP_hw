package com.example.spring_AOP_hw.controller;


import com.example.spring_AOP_hw.aspect.TrackUserAction;
import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/books/update/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updateBook ){
       return service.updateBookById(id, updateBook);
    }

    @PostMapping("/books/create")
    public Book createBook(@RequestBody Book book){
        return service.createBook(book);
    }

    @GetMapping("/books/delete/{id}")
    public void deleteBookById(@PathVariable int id){
        service.deleteBookById(id);
    }
}
