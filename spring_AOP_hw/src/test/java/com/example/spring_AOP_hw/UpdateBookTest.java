package com.example.spring_AOP_hw;

import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.repository.BookRepository;
import com.example.spring_AOP_hw.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UpdateBookTest {
    @Mock
    private BookRepository repository;
    @InjectMocks
    private BookService service;

    @Test
    public void bookUpdateTest(){

        //CONDITIONS
        Book existingBook = new Book();
        existingBook.setId(20);
        existingBook.setName("Harry Default");
        existingBook.setAuthor("Joan Default");
        existingBook.setPublishYear(1997);

        Book updatedBook = new Book();
        updatedBook.setName("Harry Potter");
        updatedBook.setAuthor("Joan Rowling");
        updatedBook.setPublishYear(1997);

        given(repository.findById(20)).willReturn(Optional.of(existingBook));
        //ACTION

        service.updateBookById(20, updatedBook);

        //CHECKING

        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
        verify(repository).save(bookCaptor.capture());
        Book savedBook = bookCaptor.getValue();

        assertThat(savedBook.getId()).isEqualTo(existingBook.getId());
        assertThat(savedBook.getName()).isEqualTo(updatedBook.getName());
        assertThat(savedBook.getAuthor()).isEqualTo(updatedBook.getAuthor());
        assertThat(savedBook.getPublishYear()).isEqualTo(updatedBook.getPublishYear());

    }

}
