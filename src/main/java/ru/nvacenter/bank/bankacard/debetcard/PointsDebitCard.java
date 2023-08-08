package ru.nvacenter.bank.bankacard.debetcard;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointsDebitCard extends DebitCard {

    //Балы за одно пополнение карты.
    private final int POINT = 10;

    //Сколько процентов за бонус.
    private final Map<Integer, Double> PERCENTSOFTHEACCUMULATED = Map.of(
            0, 0.0,
            100, 0.01,
            1000, 0.03,
            3000, 0.05
    );
    //Накопленные баллы
    private int points;

    public PointsDebitCard(double balance) {
        super(balance);
        System.out.println("Бонусная карта с баллами создана");
        getBalance();
    }

    //Оплата
    @Override
    public boolean replenish(double sum) {
        Stream<Map.Entry<Integer, Double>> entriesStream =
                PERCENTSOFTHEACCUMULATED.entrySet().stream();
        double percentOfTheAccumulated = entriesStream
                .filter(p -> p.getKey() <= points)
                .max(Map.Entry.comparingByKey())
                .get()
                .getValue();
        this.points = this.points + this.POINT;
        return super.replenish(sum + (sum * percentOfTheAccumulated));
    }

    //Получить информацию о балансе
    @Override
    public double getBalance() {
        System.out.println("Ваш баланс - " + super.getBalance() + "\n" +
                "Накопленные баллы - " + points + "\n" +
                "БОНУСНЫЕ ПРОГРАММЫ:");
        TreeMap<Integer, Double> collectSorted = PERCENTSOFTHEACCUMULATED.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o, n) -> n,
                        TreeMap::new));
        for (Map.Entry<Integer, Double> entry : collectSorted.entrySet()) {
            System.out.println("- +" + entry.getValue() + "% за " + entry.getKey() + " бонусов");
        }
        return super.getBalance();
    }
}
