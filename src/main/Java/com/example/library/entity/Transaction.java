package com.example.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long bookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String status;

    public Transaction() {}

    public Transaction(Long transactionId, Long bookId, Long userId, LocalDate issueDate, LocalDate returnDate, String status) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

