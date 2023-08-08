package ru.nvacenter.bank.bankacard.creditcard;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CashbackCreditCardTest {

    //Проеверяется работа кешбека.
    @Test
    void pay1() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Производится тестирование pay1() класса CashbackCreditCardTest");
        CashbackCreditCard cashbackCreditCard = new CashbackCreditCard(10000, 10000, 10000);
        cashbackCreditCard.pay(10000);
        Field fieldCreditCardPayments = CashbackCreditCard.class.getSuperclass().getDeclaredField("creditCardPayments");
        fieldCreditCardPayments.setAccessible(true);
        CreditCardPayments creditCardPayments = (CreditCardPayments) fieldCreditCardPayments.get(cashbackCreditCard);
        double ownFunds = creditCardPayments.getOwnFunds();
        assertEquals(500, ownFunds);
    }

    //Проеверяется работы без кешбека.
    @Test
    void pay2() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Производится тестирование pay2() класса CashbackCreditCardTest");
        CashbackCreditCard cashbackCreditCard = new CashbackCreditCard(10000, 10000, 10000);
        cashbackCreditCard.pay(5000);
        Field fieldCreditCardPayments = CashbackCreditCard.class.getSuperclass().getDeclaredField("creditCardPayments");
        fieldCreditCardPayments.setAccessible(true);
        CreditCardPayments creditCardPayments = (CreditCardPayments) fieldCreditCardPayments.get(cashbackCreditCard);
        double ownFunds = creditCardPayments.getOwnFunds();
        assertEquals(5000, ownFunds);
    }
}