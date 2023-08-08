package ru.nvacenter.bank.bankacard.creditcard;

import org.junit.jupiter.api.Test;
import ru.nvacenter.bank.result.ResultOfOperationCreditCard;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {


    //    Изначальные условия
    //    Кредитные средства: 10 000
    //    Собственные средства: 0
    //
    //    После оплаты на сумму 3 000:
    //
    //    Кредитные средства: 7 000
    //    Собственные средства: 0
    @Test
    void payTest1() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста payTest1() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 0);
        creditCard.getInfAvailable();
        boolean payStatus = creditCard.pay(3000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(7000, 0, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , payStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Изначальные условия
    //    Кредитные средства: 10 000
    //    Собственные средства: 7000
    //
    //    После оплаты на сумму 4 000:
    //
    //    Кредитные средства: 10 000
    //    Собственные средства: 3000
    @Test
    void payTest2() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста payTest2() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 7000);
        creditCard.getInfAvailable();
        boolean payStatus = creditCard.pay(4000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(10000, 3000, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , payStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Изначальные условия
    //    Кредитные средства: 10 000
    //    Собственные средства: 7000
    //
    //    После оплаты на сумму 9 000:
    //
    //    Кредитные средства: 8 000
    //    Собственные средства: 0
    @Test
    void payTest3() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста payTest3() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 7000);
        creditCard.getInfAvailable();
        boolean payStatus = creditCard.pay(9000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(8000, 0, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , payStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Изначальные условия
    //    Кредитные средства: 10 000.
    //    Собственные средства: 7000.
    //
    //    После оплаты на сумму 10 000:
    //
    //    Кредитные средства: 7 000
    //    Собственные средства: 0
    @Test
    void payTest4() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста payTest4() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 7000);
        creditCard.getInfAvailable();
        boolean payStatus = creditCard.pay(10000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(7000, 0, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , payStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Изначальные условия
    //    Кредитные средства: 10 000.
    //    Собственные средства: 7000.
    //
    //    После оплаты на сумму 17 001:
    //
    //    Кредитные средства: 8 000
    //    Собственные средства: 0
    @Test
    void payTest5() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста payTest5() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 7000);
        creditCard.getInfAvailable();
        boolean payStatus = creditCard.pay(17001);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(10000, 7000, false);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , payStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Кредитная карта с лимитом 10 000
    //    Кредитные средства: 10 000
    //    Собственные средства: 0
    //
    //    После пополнения карты на 5 000:
    //
    //    Кредитные средства: 10 000
    //    Собственные средства: 5 000
    @Test
    void replenishTest1() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста replenishTest1() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 10000, 0);
        creditCard.getInfAvailable();
        boolean replenishStatus = creditCard.replenish(5000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(10000, 5000, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , replenishStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //    Кредитные средства: 7 000.
    //    Собственные средства: 0.
    //
    //    После пополнения на 2 000:
    //
    //    Кредитные средства: 9 000.
    //    Собственные средства: 0.
    @Test
    void replenishTest2() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста replenishTest2() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 7000, 0);
        creditCard.getInfAvailable();
        boolean replenishStatus = creditCard.replenish(2000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(9000, 0, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , replenishStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }


    //    Кредитные средства: 9 000
    //    Собственные средства: 0
    //
    //    После пополнения на 2 000:
    //
    //    Кредитные средства: 10 000
    //    Собственные средства: 1 000
    @Test
    void replenishTest3() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Выполнение теста replenishTest3() класса CreditCard");
        CreditCard creditCard = new CreditCard(10000, 9000, 0);
        creditCard.getInfAvailable();
        boolean replenishStatus = creditCard.replenish(2000);
        CreditCardPayments creditCardPayments = getValueFromCreditCardPayments(creditCard);
        ResultOfOperationCreditCard resultOfOperationCreditCardExpected =
                new ResultOfOperationCreditCard(10000, 1000, true);
        ResultOfOperationCreditCard resultOfOperationCreditCardActual =
                new ResultOfOperationCreditCard(creditCardPayments.getCreditPart()
                        , creditCardPayments.getOwnFunds()
                        , replenishStatus);
        assertEquals(resultOfOperationCreditCardExpected,
                resultOfOperationCreditCardActual);
    }

    //Получаем информацию о кредитных средств.
    private CreditCardPayments getValueFromCreditCardPayments(CreditCard creditCard) throws NoSuchFieldException, IllegalAccessException {
        Field creditCardPaymentsTest = creditCard.getClass().getDeclaredField("creditCardPayments");
        creditCardPaymentsTest.setAccessible(true);
        return (CreditCardPayments) creditCardPaymentsTest.get(creditCard);
    }
}