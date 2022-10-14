package com.coffeeshop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class coffeeShopSteps {
    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private StampsTracker stampsTracker = new StampsTracker(drinkCatalog);
    LoyaltyCardHolder customer;
    @Given("the following drink categories")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer stamps = Integer.parseInt(drinkCategory.get("Stamps"));

                    drinkCatalog.addDrink(drink, category);
                    stampsTracker.addPoints(category,stamps);

                }

        );

    }
    @Given("^(.*) wants a drink")
    public void is_customer_a_loyaltyCardHolder(String name) {
         customer = new LoyaltyCardHolder(name, stampsTracker);

    }
    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void customer_purchases_drinks(String name, Integer amount, String drink) {
        customer.order(drink, amount);
    }
    @Then("They should earn {int} stamps")
    public void they_should_earn_stamps(Integer points) {
        assertThat(customer.getPoints()).isEqualTo(points);
    }
}
