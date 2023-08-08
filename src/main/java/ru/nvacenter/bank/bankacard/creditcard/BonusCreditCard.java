package ru.nvacenter.bank.bankacard.creditcard;


//Бонусные баллы в размере 1% от покупок.
public class BonusCreditCard extends CreditCard{

    //Процент от покупок
    private final double PERCENT = 1.00;

    //Бонусные баллы
    private double points;

    public BonusCreditCard(double creditLimit, double creditPart, double ownFunds) {
        super(creditLimit, creditPart, ownFunds);
        getInfAvailable();
    }

    //Оплата
    @Override
    public boolean pay(double price) {
        points = points + ((price) / 100) * PERCENT;
        return super.pay(price);
    }

    //Получение информации обо всех доступных средствах
    @Override
    public void getInfAvailable() {
        super.getInfAvailable();
        System.out.println("Ваши бонусные баллы - " + points);
        System.out.println("Бонусные программы:+\n" +
                "-Бонусные баллы в размере +" + PERCENT + "+ от покупок");
    }
}
