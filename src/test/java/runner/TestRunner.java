package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import utils.WebDriverManager;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "steps",
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}