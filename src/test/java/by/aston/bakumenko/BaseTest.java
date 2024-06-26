package by.aston.bakumenko;

import by.aston.bakumenko.driver.WebDriverSingleton;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    @Description("Настройка перед выполнением каждого теста")
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterClass
    @Description("Завершение после выполнения каждого теста")
    public void tearDown() {
        if (WebDriverSingleton.getDriver() != null) {
            WebDriverSingleton.quitDriver();
        }
    }
}