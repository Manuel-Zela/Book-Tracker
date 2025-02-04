package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book savebook(Book book, MultipartFile file) throws IOException {
        book.setPublishDateTime(LocalDateTime.now());
        if (file != null && !file.isEmpty()) {
            String uploadDir = "Book-Tracker/src/main/resources/static/book-images/";
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
            book.setImagePath("/book-images/" + fileName);
        }
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
