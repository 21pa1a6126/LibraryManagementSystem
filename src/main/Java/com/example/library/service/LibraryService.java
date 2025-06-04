package com.example.library.service;

import com.example.library.entity.*;
import com.example.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Transaction lendBook(Long bookId, Long userId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent() && book.get().isAvailable()) {
            Book b = book.get();
            b.setAvailable(false);
            bookRepository.save(b);
            Transaction t = new Transaction(null, bookId, userId, LocalDate.now(), null, "Issued");
            return transactionRepository.save(t);
        }
        return null;
    }

    public Transaction returnBook(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if (transaction.isPresent()) {
            Transaction t = transaction.get();
            t.setReturnDate(LocalDate.now());
            t.setStatus("Returned");
            transactionRepository.save(t);

            Book book = bookRepository.findById(t.getBookId()).get();
            book.setAvailable(true);
            bookRepository.save(book);
            return t;
        }
        return null;
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public List<Transaction> getUserHistory(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}

