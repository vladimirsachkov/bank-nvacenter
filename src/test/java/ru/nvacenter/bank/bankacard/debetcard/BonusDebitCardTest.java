package ru.nvacenter.bank.bankacard.debetcard;

import org.junit.jupiter.api.Test;
import ru.nvacenter.bank.result.debetcard.ResultOfOperationDebitCard;

import static org.junit.jupiter.api.Assertions.*;

//Тестирование дебетовой бонусной карты.
class BonusDebitCardTest {

    //Пополнение на сумму 50000 на карту с балансом 0
    //Ожидается баланс после пополнения 50250
    @Test
    void replenish() {
        System.out.println("Тестируется метод replenish() класса DebitCardTest");
        BonusDebitCard bonusDebitCard = new BonusDebitCard(0);
        boolean status = bonusDebitCard.replenish(50000);
        ResultOfOperationDebitCard resultOfOperationDebitCardExpected
                = new ResultOfOperationDebitCard(50250, true);
        ResultOfOperationDebitCard resultOfOperationDebitCardActual
                = new ResultOfOperationDebitCard(bonusDebitCard.getBalance(), status);
        assertEquals(resultOfOperationDebitCardExpected,
                resultOfOperationDebitCardActual);
    }

    //Получить баланс созданной карты с балансом 40000
    //Ожидается баланс 4000
    @Test
    void getBalance() {
        System.out.println("Тестирование метода getBalance() класса DebitCardTest");
        BonusDebitCard bonusDebitCard  = new BonusDebitCard(4000);
        assertEquals(4000, bonusDebitCard.getBalance());
    }
}