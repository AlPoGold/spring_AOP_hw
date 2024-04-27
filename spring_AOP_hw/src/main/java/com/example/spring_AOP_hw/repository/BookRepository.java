package com.example.spring_AOP_hw.repository;

import com.example.spring_AOP_hw.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
