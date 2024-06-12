package by.aston.bakumenko;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static by.aston.bakumenko.MtsXpath.*;

public class MtsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement iframe;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public MtsPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void openMainPage() {
        driver.get("http://mts.by");
    }


    public String getOnlineTopUpNoFeeTitle() {
        return driver.findElement(By.xpath(MtsXpath.TEXT_ONLINE_LINE_TOP_UP_NO_FREE_LOCATOR)).getText();
    }

    public void clickButtonCookie() {
        try {
            driver.findElement(By.cssSelector(MtsXpath.ENTER_BUTTON_COOKIE_LOCATOR)).click();
        } catch (NoSuchElementException e) {

        }
    }

    public void sendInputPhoneNumber(String newNumber) {
        driver.findElement(By.xpath(INPUT_PHONE_NUMBER_LOCATOR)).sendKeys(newNumber);
    }

    public void sendInputSum(String newSum) {
        driver.findElement(By.xpath(INPUT_SUM_LOCATOR)).sendKeys(newSum);
    }

    public void clickButtonContinue() {
        driver.findElement(By.id(BUTTON_CONTINUE_LOCATOR)).click();
    }

    public void switchToPaymentIframe() {
        iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TEXT_PAY_DESCRIPTION_LOCATOR)));
        driver.switchTo().frame(iframe);
    }

    public String getDropdownText() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PAYMENT_DESCRIPTION_LOCATOR)));
        return dropdown.getText();
    }

    public boolean checkLogoImagerVisaCard() {
        try {
            WebElement visaCardLogo = driver.findElement(By.xpath(LOGO_IMAGE_VISA_CARD_LOCATOR));
            return visaCardLogo != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkLogoImagerVisaVerifiedByCard() {
        try {
            WebElement visaCardVerifiedByLogo = driver.findElement(By.xpath(LOGO_IMAGE_VISA_VERIFIED_BY_CARD_LOCATOR));
            return visaCardVerifiedByLogo != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkLogoImagerMasterSecureCodeCard() {
        try {
            WebElement masterSecureCodeCardLogo = driver.findElement(By.xpath(LOGO_IMAGE_MASTER_CARD_SECURE_CODE_LOCATOR));
            return masterSecureCodeCardLogo != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkLogoImagerBilCard() {
        try {
            WebElement logoImagerBilCardLogo = driver.findElement(By.xpath(LOGO_IMAGE_BEL_CARD_LOCATOR));
            return logoImagerBilCardLogo != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean checkLogoImagerMasterCard() {
        try {
            WebElement logoImagerMasterCard = driver.findElement(By.xpath(LOGO_IMAGE_MASTER_CARD_LOCATOR));
            return logoImagerMasterCard != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}