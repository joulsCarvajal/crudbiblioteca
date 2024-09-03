package com.example.crudbibliotecatwo.service;

import com.example.crudbibliotecatwo.entity.Book;
import com.example.crudbibliotecatwo.entity.Loan;
import com.example.crudbibliotecatwo.entity.UserType;
import com.example.crudbibliotecatwo.repository.BookRepository;
import com.example.crudbibliotecatwo.repository.LoanRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public Loan createLoan(Long bookId, UserType userType, String userId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if(UserType.INVITADO.equals(userType) && hasActiveLoan(userId)){
            throw new RuntimeException("No puede solicitar más préstamos, pues ya tiene uno activo");
        }

        LocalDate loanDate = LocalDate.now();
        LocalDate returnDate = calculateReturnDate(loanDate, userType);

        Loan loan = new Loan(book, userType, userId, loanDate, returnDate);
        return loanRepository.save(loan);
    }

    private boolean hasActiveLoan(String userId) {
        return loanRepository.existsByUserIdAndReturnDateAfter(userId, LocalDate.now());
    }

    private LocalDate calculateReturnDate(LocalDate loanDate, UserType userType) {
        switch (userType) {
            case INVITADO:
                return loanDate.plusDays(10);
            case EMPLEADO:
                return loanDate.plusDays(7);
            case AFILIADO:
                return loanDate.plusDays(5);
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }

}
