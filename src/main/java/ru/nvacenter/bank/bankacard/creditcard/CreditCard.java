package ru.nvacenter.bank.bankacard.creditcard;

import ru.nvacenter.bank.bankacard.BankCard;

public class CreditCard extends BankCard {

    //Кредитный лимит
    private double creditLimit;

    //Основные средства кредитной карты
    private CreditCardPayments creditCardPayments;

    public CreditCard(double creditLimit, double creditPart, double ownFunds) {
        if (creditLimit >= creditPart) {
            this.creditLimit = creditLimit;
            this.creditCardPayments = new CreditCardPayments(creditPart, ownFunds);
            System.out.println("Кредитная карта создана.");
        } else {
            System.out.println("Кредитная часть не должна быть больше кредитного лемита.");
        }
    }

    //Пополнить
    @Override
    public boolean replenish(double sum) {
        System.out.println("Производится пополнение на сумму " + sum + "...");
        //Если на данный момент кредитные средства меньше кредитного лимита
        if (creditCardPayments.getCreditPart() < this.creditLimit) {
            //Недостаток кредитной части
            double lackOfCreditPart = this.creditLimit - creditCardPayments.getCreditPart();
            //Если сумма пополнения меньше суммы, которую нужно пополнить, чтобы заполнить лимит, то.
            if (sum < lackOfCreditPart) {
                creditCardPayments.setCreditPart(creditCardPayments.getCreditPart()+sum);
                System.out.println("Пополнение произведено");
                getInfAvailable();
                return true;
            //Если сумма пополнения больше суммы, которую нужно пополнить, чтобы заполнить лимит, то.
            } else {
                sum = sum - lackOfCreditPart;
                creditCardPayments.setCreditPart(creditCardPayments.getCreditPart() + lackOfCreditPart);
                creditCardPayments.setOwnFunds(creditCardPayments.getOwnFunds() + sum);
                System.out.println("Пополнение произведено");
                getInfAvailable();
                return true;
            }
            //Если на данный момент кредитные средства совпадают с кредитным лимитом
        } else {
            creditCardPayments.setOwnFunds(creditCardPayments.getOwnFunds() + sum);
            System.out.println("Пополнение произведено");
            getInfAvailable();
            return true;
        }
    }

    //Оплатить
    @Override
    public boolean pay(double price) {

        System.out.println("Цена - " + price);
        System.out.println("Производится оплата...");

        //Если цена больше кредитных средств - false
        if (price <= (creditCardPayments.getOwnFunds() + creditCardPayments.getCreditPart())) {
            //Если цена меньше или равно собственных средств - true
            if (price <= creditCardPayments.getOwnFunds()) {
                super.replenish(0 - price);
                creditCardPayments.setOwnFunds(creditCardPayments.getOwnFunds() - price);
                System.out.println("Оплата произведена");
                getInfAvailable();
                return true;
            //Если больше собственных средств - true
            } else {
                price = price - creditCardPayments.getOwnFunds();
                creditCardPayments.setCreditPart(creditCardPayments.getCreditPart() - price);
                creditCardPayments.setOwnFunds(0);
                System.out.println("Оплата произведена");
                getInfAvailable();
                return true;
            }
        } else {
            System.out.println("Недостаточно средств на вашей карте");
            return false;
        }
    }

    //Получить информацию о доступных средствах
    @Override
    public void getInfAvailable() {
        System.out.println("Информацию о доступных средствах:\n" +
                "Кредитные средства - " + creditCardPayments.getCreditPart() + "\n" +
                "Собственные средства - " + creditCardPayments.getOwnFunds() + "\n" +
                "Кредитный лимит - " + creditLimit);
    }
}
