package com.example.library.controller;

import com.example.library.entity.*;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService service;

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PostMapping("/lend")
    public Transaction lend(@RequestParam Long bookId, @RequestParam Long userId) {
        return service.lendBook(bookId, userId);
    }

    @PostMapping("/return")
    public Transaction returnBook(@RequestParam Long transactionId) {
        return service.returnBook(transactionId);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String keyword) {
        return service.searchBooks(keyword);
    }

    @GetMapping("/history/{userId}")
    public List<Transaction> history(@PathVariable Long userId) {
        return service.getUserHistory(userId);
    }
}
