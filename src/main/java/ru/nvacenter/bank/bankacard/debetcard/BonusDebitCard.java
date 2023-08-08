package ru.nvacenter.bank.bankacard.debetcard;

//Бонусная дебетовая карта
public class BonusDebitCard extends DebitCard {

    //
    private final double PERCENTOFTHEACCUMULATED = 0.005;

    public BonusDebitCard(double balance) {
        super(balance);
        System.out.println("Бонусная дебетовая карта создана");
        getBalance();
    }

    @Override
    public boolean replenish(double sum) {
        return super.replenish(sum + (sum * PERCENTOFTHEACCUMULATED));
    }

    @Override
    public double getBalance() {
        System.out.println("Ваш баланс - " + super.getBalance() + "\n" +
                "БОНУСНЫЕ ПРОГРАММЫ:\n" +
                "- Накопление в размере " + PERCENTOFTHEACCUMULATED + " от суммы пополнений");
        return super.getBalance();
    }
}
