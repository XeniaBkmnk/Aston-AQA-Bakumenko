package by.aston.bakumenko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Step {
    WebDriver driver;
    MtsPage mtsPage;
    private static final Logger LOGGER = LogManager.getLogger();

    public Step() {
        this.driver = WebDriverSingleton.getDriver();
        this.mtsPage = new MtsPage();
        LOGGER.info("WebDriver is created in LoginStep constructor");
    }

    public void openMainByMts() {
        mtsPage.openMainPage();
        mtsPage.clickButtonCookie();
    }
}