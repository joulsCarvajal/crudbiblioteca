package com.example.crudbibliotecatwo.controller;

import com.example.crudbibliotecatwo.entity.Loan;
import com.example.crudbibliotecatwo.entity.UserType;
import com.example.crudbibliotecatwo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;
    @PostMapping("/{bookId}/{userType}/{userId}")
    public ResponseEntity<?> createLoad(@PathVariable Long bookId,
                                        @PathVariable UserType userType,
                                        @PathVariable String userId) {
        try {
            Loan loan = loanService.createLoan(bookId, userType, userId);
            return ResponseEntity.ok()
                    .body(Map.of("bookId", loan.getBook().getBookId(),
                            "returnDate", loan.getReturnDate()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("LoadController is working");
    }

}