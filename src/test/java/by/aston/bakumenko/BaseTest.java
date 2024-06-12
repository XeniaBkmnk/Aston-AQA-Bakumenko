package by.aston.bakumenko;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        if (WebDriverSingleton.getDriver() != null) {
            WebDriverSingleton.quitDriver();
        }
    }
}