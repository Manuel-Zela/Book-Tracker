package com.example.controller;

import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    private String index(Model model){
        return "website/index";
    }

}
