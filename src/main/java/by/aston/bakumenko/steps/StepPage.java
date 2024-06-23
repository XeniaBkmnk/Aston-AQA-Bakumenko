package by.aston.bakumenko.steps;

import by.aston.bakumenko.pages.MtsPage;
import by.aston.bakumenko.driver.WebDriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class StepPage {
    WebDriver driver;
    MtsPage mtsPage;
    private static final Logger LOGGER = LogManager.getLogger();

    public StepPage() {
        this.driver = WebDriverSingleton.getDriver();
        this.mtsPage = new MtsPage();
        LOGGER.info("WebDriver is created in LoginStep constructor");
    }

    public void openMainByMts() {
        mtsPage.openMainPage();
        mtsPage.clickButtonCookie();
    }
}