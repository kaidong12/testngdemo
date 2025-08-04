package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverManager;

import java.util.List;

public class SearchSteps {
    private WebDriver driver;

    @Given("I start browser")
    public void iStartBrowser() {
        driver = WebDriverManager.getDriver();
    }

    @Given("I open Baidu homepage")
    public void iOpenBaiduHomepage() {
        driver.get("https://www.baidu.com");
    }

    @Given("I open Bing homepage")
    public void iOpenBingHomepage() {
        driver.get("https://www.baidu.com");
    }

    @When("I search for {string}")
    public void iSearchFor(String keyword) {
        WebElement searchBox = driver.findElement(By.id("kw"));
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }

    @Then("I should see more than {int} results")
    public void iShouldSeeMoreThanResults(int minResults) {
        List<WebElement> elements =  driver.findElements(By.cssSelector("h3 a"));
        int count = elements.size();

        Assert.assertTrue(count > minResults,
            "Expected more than " + minResults + " results, but found " + count);
    }
}
