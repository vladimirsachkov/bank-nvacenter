package ru.nvacenter.bank.result;

import java.util.Objects;

//Этот класс преднозначен для хранения результатов оплаты.
public class ResultOfOperationCreditCard {
    //кредитная часть
    private double creditPart;
    //собственные средства
    private double ownFunds;
    //Статус оплаты
    private boolean status;

    public ResultOfOperationCreditCard(double creditPart, double ownFunds, boolean status) {
        this.creditPart = creditPart;
        this.ownFunds = ownFunds;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOfOperationCreditCard that = (ResultOfOperationCreditCard) o;
        return Double.compare(that.creditPart, creditPart) == 0 && Double.compare(that.ownFunds, ownFunds) == 0 && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditPart, ownFunds, status);
    }
}
