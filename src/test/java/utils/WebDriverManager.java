package utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Point position1 = driver.manage().window().getPosition();
        System.out.println(position1.getX());
        System.out.println(position1.getY());

        Point pos = new Point(0, 500);
        driver.manage().window().setPosition(pos);
        Point position2 = driver.manage().window().getPosition();
        System.out.println(position2.getX());
        System.out.println(position2.getY());

        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
