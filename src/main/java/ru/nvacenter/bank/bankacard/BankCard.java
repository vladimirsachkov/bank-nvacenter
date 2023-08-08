package ru.nvacenter.bank.bankacard;

public class BankCard {

    //Баланс
    private double balance;

    public BankCard() {
    }

    public BankCard(double balance) {
        this.balance = balance;
    }

    //Пополнить
    public boolean replenish(double sum) {
        balance = balance + sum;
        System.out.println("Ваш баланс пополнен на " + sum);
        getBalance();
        return true;
    }

    //Оплатить
    public boolean pay(double price) {
        if (price < balance) {
            System.out.println("У вас недостаточно средств.");
            return false;
        } else {
            balance = balance - price;
            System.out.println("Оплата проивезедена");
            return true;
        }
    };

    //Получить информацию о балансе
    public double getBalance() {
        return balance;
    }

    //Получить информацию о доступных средствах

    public void getInfAvailable() {
        System.out.println("Доступные средства:\n" +
                "Баланс - " + balance);
    }
}
