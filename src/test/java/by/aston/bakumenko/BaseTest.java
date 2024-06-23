package by.aston.bakumenko;

import by.aston.bakumenko.driver.WebDriverSingleton;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    @Description("Настройка перед выполнением каждого теста")
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @After
    @Description("Завершение после выполнения каждого теста")
    public void tearDown() {
        if (WebDriverSingleton.getDriver() != null) {
            WebDriverSingleton.quitDriver();
        }
    }
}