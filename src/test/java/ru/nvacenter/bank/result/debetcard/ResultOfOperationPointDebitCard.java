package ru.nvacenter.bank.result.debetcard;

import ru.nvacenter.bank.result.creditcard.ResultOfOperationCreditCard;

import java.util.Objects;

//Это класс, который записывает результаты операций над дебетовой картой c накоплением бонусов.
public class ResultOfOperationPointDebitCard extends ResultOfOperationDebitCard {
    //Накопленные бонусы
    private int points;

    public ResultOfOperationPointDebitCard(double balance, boolean status, int points) {
        super(balance, status);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ResultOfOperationPointDebitCard that = (ResultOfOperationPointDebitCard) o;
        return points == that.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), points);
    }
}
