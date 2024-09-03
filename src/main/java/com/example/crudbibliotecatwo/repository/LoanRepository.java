package com.example.crudbibliotecatwo.repository;

import com.example.crudbibliotecatwo.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByUserIdAndReturnDateAfter(String userId, LocalDate date);
}
