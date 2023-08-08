package ru.nvacenter.bank.bankacard.creditcard;

public class CreditCardPayments {

    //кредитная часть
    private double creditPart;

    //собственные средства
    private double ownFunds;

    public CreditCardPayments(double creditPart, double ownFunds) {
        this.creditPart = creditPart;
        this.ownFunds = ownFunds;
    }

    public double getCreditPart() {
        return creditPart;
    }

    public void setCreditPart(double creditPart) {
        this.creditPart = creditPart;
    }

    public double getOwnFunds() {
        return ownFunds;
    }

    public void setOwnFunds(double ownFunds) {
        this.ownFunds = ownFunds;
    }
}
