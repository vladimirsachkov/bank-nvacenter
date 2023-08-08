package ru.nvacenter.bank.bankacard.debetcard;

import ru.nvacenter.bank.bankacard.BankCard;

public class DebitCard extends BankCard {
    public DebitCard(double balance) {
        super(balance);
        System.out.println("Создана дебетовая карта");
        super.getBalance();
    }

    //Пополнить
    @Override
    public boolean replenish(double sum) {
        return super.replenish(sum);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }
}
