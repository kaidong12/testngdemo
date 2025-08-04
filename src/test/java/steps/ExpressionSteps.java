package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverManager;

import java.util.List;

public class ExpressionSteps {
    private WebDriver driver;

    @Given("I start demo")
    public void iStartBrowser() {
        System.out.println("========== Start to demo ==========");
    }

    @Given("I open text file {string}")
    public void iOpenTextFile(String fileName) {
        System.out.println("I open text file: " + fileName);
    }

    @Given("I open calculator")
    public void iOpenCalculator() {
        System.out.println("I open calculator");
    }

    @When("I input string {string}")
    public void iInputText(String text) {
        System.out.println("I input text: " + text);
    }

    @Then("I should see word {string} in text file")
    public void iShouldSeeText(String text) {
        System.out.println("I should see text: " + text);

        Assert.assertNotNull(text, "Expected text: " + text);
    }

    @When("I input word {word}")
    public void iInputWord(String word) {
        System.out.println("I input word: " + word);
    }

    @Then("I should see string {string} in text file")
    public void iShouldSeeWord(String word) {
        System.out.println("I should see word: " + word);

        Assert.assertNotNull(word, "Expected text: " + word);
    }

    @When("I input int {int}")
    public void iInputNumber(int number) {
        System.out.println("I input int number: " + number);
    }

    @When("I input float {float}")
    public void iInputNumber(float number) {
        System.out.println("I input float number: " + number);
    }

    @Then("I should see int {int} in calculator")
    public void iShouldSeeNumber(int number) {
        System.out.println("I should see int number: " + number);

        Assert.assertTrue(number > 0,"Expected text: " + number);
    }

    @Then("I should see float {float} in calculator")
    public void iShouldSeeNumber(float number) {
        System.out.println("I should see float number: " + number);

        Assert.assertTrue(number > 0,"Expected text: " + number);
    }
}
