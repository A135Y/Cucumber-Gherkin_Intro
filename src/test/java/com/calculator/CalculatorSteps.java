package com.calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorSteps {
    Calculator calculator;
    Integer result;
    @Given("I have a calculator")
    public void i_have_a_calculator(){
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b){
        result = calculator.add(a,b);
    }
    @Then("I should get {int}")
    public void i_should_get(Integer int1) {
        assertThat(result).isEqualTo(int1);
    }

}

