package by.aston.bakumenko.steps;

import by.aston.bakumenko.pages.MtsPage;
import by.aston.bakumenko.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class StepPage {
    WebDriver driver;
    MtsPage mtsPage;

    public StepPage() {
        this.driver = WebDriverSingleton.getDriver();
        this.mtsPage = new MtsPage();
    }

    public void openMainByMts() {
        mtsPage.openMainPage();
        mtsPage.clickButtonCookie();
    }
}