package com.example.Book.Tracker.controller;

import com.example.Book.Tracker.model.Book;
import com.example.Book.Tracker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    private String index(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }
    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.savebook(book);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
