package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    public BookService bookService;

    @GetMapping("/admin")
    private String index(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/admin";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("imageFile") MultipartFile file) {
        try {
            bookService.savebook(book, file);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin?error";
        }
        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin";
    }
}
