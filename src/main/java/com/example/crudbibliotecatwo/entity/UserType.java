package com.example.crudbibliotecatwo.entity;

public enum UserType {
    AFILIADO(10),
    EMPLEADO(7),
    INVITADO(5);

    private final int maxLoanDays;

    UserType(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public int getMaxLoanDays(){
        return maxLoanDays;
    }
}

