package com.coffeeshop;

import java.util.HashMap;
import java.util.Map;

public class StampsTracker {

private Map<String,Integer> stampsPerCategory = new HashMap<>();
private DrinkCatalog catalog;

    public StampsTracker(DrinkCatalog catalog){
        this.catalog = catalog;
    }
    public void addPoints(String category,Integer points) {
       stampsPerCategory.put(category,points);
    }

    public int getStampsFor(String drink) {
        return stampsPerCategory.get(categoryOf(drink));
    }

    private String categoryOf(String drink) {
        return catalog.getDrinkCategory(drink);
    }
}
