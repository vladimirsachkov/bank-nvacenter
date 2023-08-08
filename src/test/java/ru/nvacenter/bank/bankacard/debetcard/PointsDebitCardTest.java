package ru.nvacenter.bank.bankacard.debetcard;

import org.junit.jupiter.api.Test;
import ru.nvacenter.bank.result.debetcard.ResultOfOperationDebitCard;
import ru.nvacenter.bank.result.debetcard.ResultOfOperationPointDebitCard;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PointsDebitCardTest {


    //Карта: баланс 10, 0 бонусов
    //пополнение на 3
    //Ожидается: баланс - 4, статус операции - true, накопленные баллы - 10.
    @Test
    void replenish1() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тестирование метода replenish1() класса DebitCardTest");
        ResultOfOperationPointDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationPointDebitCard(4, true, 10);
        ResultOfOperationDebitCard resultOfOperationPointDebitCardActual
                = getResultOfOperationReplenishPointDebitCardActual(0, 4, 0);
        assertEquals(resultOfOperationDebitCardExpected,
                resultOfOperationPointDebitCardActual);
    }

    //Карта: баланс 0, 100 - бонусов
    //пополнение на 50000
    //Ожидается: баланс - 4, статус операции - true, накопленные баллы - 110.
    @Test
    void replenish2() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тестирование метода replenish2() класса DebitCardTest");
        ResultOfOperationPointDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationPointDebitCard(50500, true, 110);
        ResultOfOperationDebitCard resultOfOperationPointDebitCardActual
                = getResultOfOperationReplenishPointDebitCardActual(0, 50000, 100);
        assertEquals(resultOfOperationDebitCardExpected,
                resultOfOperationPointDebitCardActual);
    }

    //Карта: баланс 0, 1000 - бонусов
    //пополнение на 50000
    //Ожидается: баланс - 4, статус операции - true, накопленные баллы - 1010.
    @Test
    void replenish3() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тестирование метода replenish3() класса DebitCardTest");
        ResultOfOperationPointDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationPointDebitCard(51500, true, 1010);
        ResultOfOperationDebitCard resultOfOperationPointDebitCardActual
                = getResultOfOperationReplenishPointDebitCardActual(0, 50000, 1000);
        assertEquals(resultOfOperationDebitCardExpected,
                resultOfOperationPointDebitCardActual);
    }

    //Карта: баланс 0, 3000 - бонусов
    //пополнение на 50000
    //Ожидается: баланс - 52500, статус операции - true, накопленные баллы - 3010.
    @Test
    void replenish4() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тестирование метода replenish4() класса DebitCardTest");
        ResultOfOperationPointDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationPointDebitCard(52500, true, 3010);
        ResultOfOperationDebitCard resultOfOperationPointDebitCardActual
                = getResultOfOperationReplenishPointDebitCardActual(0, 50000, 3000);
        assertEquals(resultOfOperationDebitCardExpected,
                resultOfOperationPointDebitCardActual);
    }

    //Создание дебетовой карты с балансом 5000.
    //Ожидается 5000
    @Test
    void getBalance() {
        System.out.println("Тестируется метод getBalance()");
        PointsDebitCard debitCard = new PointsDebitCard(5000);
        double balance = debitCard.getBalance();
        assertEquals(5000, balance);
    }

    //Возвращает результат с разными параметрами.
    //balance - начальный баланс, sum - сумма пополнения, fieldPoints - бонусные очки
    private ResultOfOperationPointDebitCard getResultOfOperationReplenishPointDebitCardActual(double balance
            , double sum, int fieldPoints) throws NoSuchFieldException, IllegalAccessException {
        PointsDebitCard pointsDebitCard = new PointsDebitCard(balance);
        Field pointsField = pointsDebitCard.getClass().getDeclaredField("points");
        pointsField.setAccessible(true);
        pointsField.set(pointsDebitCard, fieldPoints);
        boolean status = pointsDebitCard.replenish(sum);
        return new ResultOfOperationPointDebitCard(pointsDebitCard.getBalance(), status, (Integer) pointsField.get(pointsDebitCard));
    }
}