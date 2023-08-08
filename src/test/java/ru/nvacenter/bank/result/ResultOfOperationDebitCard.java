package ru.nvacenter.bank.result;

import java.util.Objects;

//Это класс, который записывает результаты операций над дебетовой картой.
public class ResultOfOperationDebitCard {
    private double balance;
    private boolean status;

    public ResultOfOperationDebitCard(double balance, boolean status) {
        this.balance = balance;
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOfOperationDebitCard that = (ResultOfOperationDebitCard) o;
        return Double.compare(that.balance, balance) == 0 && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, status);
    }
}
