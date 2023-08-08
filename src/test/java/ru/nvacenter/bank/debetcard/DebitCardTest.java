package ru.nvacenter.bank.debetcard;

import org.junit.jupiter.api.Test;
import ru.nvacenter.bank.bankacard.debetcard.DebitCard;
import ru.nvacenter.bank.result.ResultOfOperationDebitCard;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {

    //Пополнение на 9000 c балансом 5000.
    //Ожидается 14000
    @Test
    void replenish() {
        System.out.println("Тестируется метод replenish() класса DebitCard");
        DebitCard debitCard = new DebitCard(5000);
        boolean status = debitCard.replenish(9000);
        ResultOfOperationDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationDebitCard(14000, true);
        ResultOfOperationDebitCard resultOfOperationDebitCardActual
                = new ResultOfOperationDebitCard(debitCard.getBalance(), status);
        assertEquals(resultOfOperationDebitCardExpected
                , resultOfOperationDebitCardActual);
    }

    //Создание дебетовой карты с балансом 4000.
    //Ожидается 4000
    @Test
    void getBalance() {
        System.out.println("Тестируется метод getBalance()");
        DebitCard debitCard = new DebitCard(4000);
        double balance = debitCard.getBalance();
        assertEquals(4000, balance);
    }
}