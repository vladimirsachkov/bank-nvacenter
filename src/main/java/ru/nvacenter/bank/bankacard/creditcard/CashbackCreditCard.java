package ru.nvacenter.bank.bankacard.creditcard;


//Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000 тыс.
public class CashbackCreditCard extends CreditCard {

    //Потенциальный кэшбэк 5%
    private final double PERCENT = 5;

    //при условии трат больше 5 000 тыс.
    private final double PRICE = 5000;

    public CashbackCreditCard(double creditLimit, double creditPart, double ownFunds) {
        super(creditLimit, creditPart, ownFunds);
    }

    //Оплатить
    @Override
    public boolean pay(double price) {
        boolean status = super.pay(price);
        if ((price > PRICE) && status) {
            double cachback = (price / 100) * PERCENT;
            status = super.replenish(cachback);
            System.out.println("Получен кешбэк от покупки - " + cachback);
        }
        return status;
    }

    //Получить информацию о доступных средствах
    @Override
    public void getInfAvailable() {
        super.getInfAvailable();
        System.out.println("Бонусные программы:");
        System.out.println("Потенциальный кэшбэк + " + PERCENT + " + от покупок при условии трат больше " + PRICE);
    }
}
