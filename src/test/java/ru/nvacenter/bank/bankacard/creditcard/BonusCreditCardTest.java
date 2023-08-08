package ru.nvacenter.bank.bankacard.creditcard;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BonusCreditCardTest {

    @Test
    void pay() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Тестируется метод replenish() класса BonusCreditCardTest");
        BonusCreditCard bonusCreditCard = new BonusCreditCard(10000, 10000, 4000);
        bonusCreditCard.pay(1000);
        Field fieldPoints = bonusCreditCard.getClass().getDeclaredField("points");
        fieldPoints.setAccessible(true);
        double points = (double) fieldPoints.get(bonusCreditCard);
        assertEquals(10, points);
    }
}