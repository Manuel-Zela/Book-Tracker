package com.example.Book.Tracker.service;

import com.example.Book.Tracker.model.Book;
import com.example.Book.Tracker.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book savebook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}