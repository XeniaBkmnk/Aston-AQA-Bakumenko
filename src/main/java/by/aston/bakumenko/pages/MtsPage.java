package by.aston.bakumenko.pages;

import by.aston.bakumenko.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MtsPage {
    private WebDriver driver;
    private WebElement iframe;
    private final String TEXT_ONLINE_LINE_TOP_UP_NO_FREE_LOCATOR = "//*[@id='pay-section']//h2";
    private final String ENTER_BUTTON_COOKIE_LOCATOR = "button#cookie-agree";
    private final String LOGO_IMAGE_VISA_CARD_LOCATOR = "//*[@id='pay-section']//img[contains(@src, 'visa.svg')]";
    private final String LOGO_IMAGE_VISA_VERIFIED_BY_CARD_LOCATOR = "//div[@id='pay-section']//ul/li[2]/img";
    private final String LOGO_IMAGE_MASTER_CARD_LOCATOR = "//*[@id='pay-section']//ul/li[3]/img";
    private final String LOGO_IMAGE_MASTER_CARD_SECURE_CODE_LOCATOR = "//div[@id='pay-section']//li[4]/img";
    private final String LOGO_IMAGE_BEL_CARD_LOCATOR = "//*[@id='pay-section']//ul/li[5]/img";
    private final String INPUT_PHONE_NUMBER_LOCATOR = "//*[@id='connection-phone']";
    private final String INPUT_SUM_LOCATOR = "//*[@id='connection-sum']";
    private final String BUTTON_CONTINUE_LOCATOR = "//*[@id='pay-connection']/button";
    private final String TEXT_PAY_DESCRIPTION_LOCATOR = "//iframe[@class='bepaid-iframe']";
    private final String PAYMENT_DESCRIPTION_LOCATOR = "span.pay-description__text";
    private final String NAME_LIST_OF_COMMUNICATION_SERVICES = "//span[@class='select__now']";
    private final String PHONE_NUMBER_IN_COMMUNICATION_SERVICES = "//input[@placeholder='Номер телефона']";
    private final String SUM_IN_COMMUNICATION_SERVICES = "//*[contains(@placeholder, 'Сумма')]";
    private final String EMAIL_IN_COMMUNICATION_SERVICES = "//*[@id='connection-email']";
    private final String BUTTON_POPUP_MENU = "//*[@id='pay-section']//button";
    private final String BUTTON_CHOOSE_HOME_INTERNET = "//*[@id='pay-section']//ul/li[2]/p";
    private final String CHOOSE_HOME_INTERNET = "//*[@id='pay-section']//button//span";
    private final String SUBSCRIBER_NUMBER_ON_HOME_INTERNET = "//*[@id='internet-phone']";
    private final String SUM_ON_HOME_INTERNET = "//*[@id='internet-sum']";
    private final String EMAIL_ON_HOME_INTERNET = "//*[@id='internet-email']";
    private final String BUTTON_ON_INSTALLMENT_PLAN = "//*[@id='pay-section']//ul/li[3]";
    private final String CHOOSE_INSTALLMENT_PLAN = "//*[@id='pay-section']//button//span[1]";
    private final String SUBSCRIBER_NUMBER_ON_INSTALLMENT_PLAN = "//*[@id='internet-phone']";
    private final String SUM_ON_INSTALLMENT_PLAN = "//*[@id='internet-sum']";
    private final String EMAIL_ON_INSTALLMENT_PLAN = "//*[@id='internet-email']";
    private final String BUTTON_DEBT = "//*[@id='pay-section']//ul/li[4]";
    private final String CHOOSE_DEBT = "//*[@id=\"pay-section\"]//button//span[1]";
    private final String ACCOUNT_NUMBER_ON_DEBT = "//*[@id='score-arrears']";
    private final String TOTAL_SUM_ELEMENT = "//app-payment-container/section/div/div/div/span[1]";
    private final String PAY_DESCRIPTION = "//*[contains(text(), 'Оплата:')]";
    private final String BUTTON_PAY = "//app-card-page/div/div[1]//button";
    private final String CARD_NUMBER_LABEL = "//label[@class='ng-tns-c46-1 ng-star-inserted']";
    private final String VALIDITY_LABEL = "//label[@class='ng-tns-c46-4 ng-star-inserted']";
    private final String CVC_LABEL = "//label[@class='ng-tns-c46-5 ng-star-inserted']";
    private final String HOLDER_NAME_LABEL = "//label[@class='ng-tns-c46-3 ng-star-inserted']";
    private final String MASTER_CARD_ICON = "//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']";
    private final String VISA_ICON = "//img[@src='assets/images/payment-icons/card-types/visa-system.svg']";
    private final String BELKART_ICON = "//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']";
    private final String MIR_ICON = "//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']";
    private final String BUTTON_GOOGLE_PAY = "//button[@aria-label='Google Pay']";
    private final String BUTTON_YANDEX_PAY = "//button[@aria-label='Yandex Pay']";

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public MtsPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void openMainPage() {
        driver.get("http://mts.by");
    }


    public String getOnlineTopUpNoFeeTitle() {
        return driver.findElement(By.xpath(TEXT_ONLINE_LINE_TOP_UP_NO_FREE_LOCATOR)).getText();
    }

    public void clickButtonCookie() {
        try {
            driver.findElement(By.cssSelector(ENTER_BUTTON_COOKIE_LOCATOR)).click();
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
        driver.findElement(By.xpath(BUTTON_CONTINUE_LOCATOR)).click();
    }

    public void switchToPaymentIframe() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        iframe = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_PAY_DESCRIPTION_LOCATOR)));
        driver.switchTo().frame(iframe);
    }

    public String getDropdownText() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PAYMENT_DESCRIPTION_LOCATOR)));
        return dropdown.getText();
    }

    public List<Boolean> searchLogoImages() {
        List<String> locators = new ArrayList<>();
        locators.add(LOGO_IMAGE_VISA_CARD_LOCATOR);
        locators.add(LOGO_IMAGE_VISA_VERIFIED_BY_CARD_LOCATOR);
        locators.add(LOGO_IMAGE_MASTER_CARD_SECURE_CODE_LOCATOR);
        locators.add(LOGO_IMAGE_BEL_CARD_LOCATOR);
        locators.add(LOGO_IMAGE_MASTER_CARD_LOCATOR);

        List<Boolean> results = new ArrayList<>();
        for (String locator : locators) {
            try {
                WebElement logo = driver.findElement(By.xpath(locator));
                results.add(logo != null);
            } catch (NoSuchElementException e) {
                results.add(false);
            }
        }
        return results;
    }

    public String getPhoneNumberInCommunicationServices() {
        return driver.findElement(By.xpath(PHONE_NUMBER_IN_COMMUNICATION_SERVICES)).getAttribute("placeholder");
    }

    public String getNameListOfCommunicationServices() {
        return driver.findElement(By.xpath(NAME_LIST_OF_COMMUNICATION_SERVICES)).getText();
    }

    public String getSumInCommunicationServices() {
        return driver.findElement(By.xpath(SUM_IN_COMMUNICATION_SERVICES)).getAttribute("placeholder");
    }

    public String getEmailInCommunicationServices() {
        return driver.findElement(By.xpath(EMAIL_IN_COMMUNICATION_SERVICES)).getAttribute("placeholder");
    }

    public void clickButtonPopupMenu() {
        driver.findElement(By.xpath(BUTTON_POPUP_MENU)).click();
    }

    public void clickHomeInternet() {
        driver.findElement(By.xpath(BUTTON_CHOOSE_HOME_INTERNET)).click();
    }

    public String getTextHomeInternet() {
        return driver.findElement(By.xpath(CHOOSE_HOME_INTERNET)).getText();
    }

    public String getSubscriberNumber() {
        return driver.findElement(By.xpath(SUBSCRIBER_NUMBER_ON_HOME_INTERNET)).getAttribute("placeholder");
    }

    public String getSumOnHomeInternet() {
        return driver.findElement(By.xpath(SUM_ON_HOME_INTERNET)).getAttribute("placeholder");
    }

    public String getEmailOnHomeInternet() {
        return driver.findElement(By.xpath(EMAIL_ON_HOME_INTERNET)).getAttribute("placeholder");
    }

    public void clickInstallmentPlan() {
        driver.findElement(By.xpath(BUTTON_ON_INSTALLMENT_PLAN)).click();
    }

    public String getTextInstallmentPlan() {
        return driver.findElement(By.xpath(CHOOSE_INSTALLMENT_PLAN)).getText();
    }

    public String getSubscriberNumberInInstallmentPlan() {
        return driver.findElement(By.xpath(SUBSCRIBER_NUMBER_ON_INSTALLMENT_PLAN)).getAttribute("placeholder");
    }

    public String getSumInInstallmentPlan() {
        return driver.findElement(By.xpath(SUM_ON_INSTALLMENT_PLAN)).getAttribute("placeholder");
    }

    public String getEmailInInstallmentPlan() {
        return driver.findElement(By.xpath(EMAIL_ON_INSTALLMENT_PLAN)).getAttribute("placeholder");
    }

    public void clickButtonDebt() {
        driver.findElement(By.xpath(BUTTON_DEBT)).click();
    }

    public String getTextDebt() {
        return driver.findElement(By.xpath(CHOOSE_DEBT)).getText();
    }

    public String getTextAccountNumber() {
        return driver.findElement(By.xpath(ACCOUNT_NUMBER_ON_DEBT)).getAttribute("placeholder");
    }

    public WebElement getTotalSumElement() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalSumElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOTAL_SUM_ELEMENT)));
        return totalSumElement;
    }

    public WebElement getPayDescription() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payDescription = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAY_DESCRIPTION)));
        return payDescription;
    }

    public WebElement getPayButton() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_PAY)));
        return payButton;
    }

    public WebElement getCardNumberLabel() {
        return driver.findElement(By.xpath(CARD_NUMBER_LABEL));
    }

    public WebElement getValidityLabel() {
        return driver.findElement(By.xpath(VALIDITY_LABEL));
    }

    public WebElement getCvcLabel() {
        return driver.findElement(By.xpath(CVC_LABEL));
    }

    public WebElement getHolderNameLabel() {
        return driver.findElement(By.xpath(HOLDER_NAME_LABEL));
    }

    public WebElement getMastercardIcon() {
        return driver.findElement(By.xpath(MASTER_CARD_ICON));
    }

    public WebElement getVisaIcon() {
        return driver.findElement(By.xpath(VISA_ICON));
    }

    public WebElement getBelkartIcon() {
        return driver.findElement(By.xpath(BELKART_ICON));
    }

    public WebElement getMirIcon() {
        return driver.findElement(By.xpath(MIR_ICON));
    }

    public WebElement getGooglePayButton() {
        return driver.findElement(By.xpath(BUTTON_GOOGLE_PAY));
    }

    public WebElement getYandexPayButton() {
        return driver.findElement(By.xpath(BUTTON_YANDEX_PAY));
    }
}