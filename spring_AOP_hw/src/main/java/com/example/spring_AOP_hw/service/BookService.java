package com.example.spring_AOP_hw.service;

import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository repository;


    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Book getBookById(int id){
        return repository.findById(id).orElse(null);
    }
}
