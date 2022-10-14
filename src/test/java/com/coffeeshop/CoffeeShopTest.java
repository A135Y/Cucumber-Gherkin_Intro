package com.coffeeshop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:coffeeshop",
glue = "com.coffeeshop")

public class CoffeeShopTest {
}


