package com.coffeeshop;

public class LoyaltyCardHolder {
    private String name;
    private StampsTracker catalog;
    private int earnedPoints;

    public LoyaltyCardHolder(String name, StampsTracker catalog) {
        this.catalog = catalog;
        this.name = name;
    }

    public void order(String drink, Integer amount) {
        earnedPoints = catalog.getStampsFor(drink) * amount;
    }

    public int getPoints() { return earnedPoints; }
}
