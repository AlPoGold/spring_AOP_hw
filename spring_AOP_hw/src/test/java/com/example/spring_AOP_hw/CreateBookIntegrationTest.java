package com.example.spring_AOP_hw;


import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.repository.BookRepository;
import com.example.spring_AOP_hw.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateBookIntegrationTest {

    @MockBean
    private BookRepository repository;
    @Autowired
    private BookService service;

    @Test
    public void bookCreatedTest(){
        //CONDITIONS

        Book newBook = new Book();
        newBook.setName("Lord of the Flies");
        newBook.setAuthor("William Golding");
        newBook.setPublishYear(1954);

        //ACTION
        service.createBook(newBook);

        //CHECKING

        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
        verify(repository).save(bookCaptor.capture());
        Book savedBook = bookCaptor.getValue();

        assertThat(savedBook.getName()).isEqualTo("Lord of the Flies");
        assertThat(savedBook.getAuthor()).isEqualTo("William Golding");
        assertThat(savedBook.getPublishYear()).isEqualTo(1954);
    }
}
