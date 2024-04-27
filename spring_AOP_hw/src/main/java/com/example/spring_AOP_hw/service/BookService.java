package com.example.spring_AOP_hw.service;

import com.example.spring_AOP_hw.aspect.TrackUserAction;
import com.example.spring_AOP_hw.model.Book;
import com.example.spring_AOP_hw.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository repository;


    @TrackUserAction(method = "show all books")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @TrackUserAction(method = "show book by id")
    public Book getBookById(int id){
        return repository.findById(id).orElse(null);
    }


    @TrackUserAction(method="create")
    public Book createBook(Book book){
        return  repository.save(book);
    }

    @TrackUserAction(method="delete")
    public void deleteBookById(int id){
         repository.deleteById(id);
    }

    @TrackUserAction(method = "update")
    public Book updateBookById(int id, Book updatedBook){
        Book oldBook = repository.findById(id).orElse(null);
        if(oldBook!=null){
            oldBook.setName(updatedBook.getName());
            oldBook.setAuthor(updatedBook.getAuthor());
            oldBook.setPublishYear(updatedBook.getPublishYear());
            return repository.save(oldBook);
        }else{
           return repository.save(updatedBook);
        }
    }
}
