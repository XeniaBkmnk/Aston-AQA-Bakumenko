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
    private final String textOnlineLineTopUpNoFree = "//*[@id='pay-section']//h2";
    private final String enterButtonCookie = "button#cookie-agree";
    private final String logoImageVisaCard = "//*[@id='pay-section']//img[contains(@src, 'visa.svg')]";
    private final String logoImageVisaVerifiedByCard = "//div[@id='pay-section']//ul/li[2]/img";
    private final String logoImageMasterCard = "//*[@id='pay-section']//ul/li[3]/img";
    private final String logoImageMasterCardSecureCode = "//div[@id='pay-section']//li[4]/img";
    private final String logoImageBelCardLocator = "//*[@id='pay-section']//ul/li[5]/img";
    private final String inputPhoneNumber = "//*[@id='connection-phone']";
    private final String inputSum = "//*[@id='connection-sum']";
    private final String buttonContinue = "//*[@id='pay-connection']/button";
    private final String textPayDescription = "//iframe[@class='bepaid-iframe']";
    private final String paymentDescription = "span.pay-description__text";
    private final String nameListOfCommunicationServices = "//span[@class='select__now']";
    private final String phoneNumberInCommunicationServices = "//input[@placeholder='Номер телефона']";
    private final String sumInCommunicationServices = "//*[contains(@placeholder, 'Сумма')]";
    private final String emailInCommunicationServices = "//*[@id='connection-email']";
    private final String buttonPopupMenu = "//*[@id='pay-section']//button";
    private final String buttonChooseHomeInternet = "//*[@id='pay-section']//ul/li[2]/p";
    private final String chooseHomeInternet = "//*[@id='pay-section']//button//span";
    private final String subscriberNumberOnHomeInternet = "//*[@id='internet-phone']";
    private final String sumOnHomeInternet = "//*[@id='internet-sum']";
    private final String emailOnHomeInternet = "//*[@id='internet-email']";
    private final String buttonOnInstallmentPlan = "//*[@id='pay-section']//ul/li[3]";
    private final String chooseInstallmentPlan = "//*[@id='pay-section']//button//span[1]";
    private final String subscriberNumberOnInstallmentPlan = "//*[@id='internet-phone']";
    private final String sumOnInstallmentPlan = "//*[@id='internet-sum']";
    private final String emailOnInstallmentPlan = "//*[@id='internet-email']";
    private final String buttonDebt = "//*[@id='pay-section']//ul/li[4]";
    private final String chooseDebt = "//*[@id=\"pay-section\"]//button//span[1]";
    private final String ACCOUNT_NUMBER_ON_DEBT = "//*[@id='score-arrears']";
    private final String totalSumElement = "//app-payment-container/section/div/div/div/span[1]";
    private final String payDescription = "//*[contains(text(), 'Оплата:')]";
    private final String buttonPay = "//app-card-page/div/div[1]//button";
    private final String cardNumberLabel = "//label[@class='ng-tns-c46-1 ng-star-inserted']";
    private final String validityLabel = "//label[@class='ng-tns-c46-4 ng-star-inserted']";
    private final String cvcLabel = "//label[@class='ng-tns-c46-5 ng-star-inserted']";
    private final String holderNameLabel = "//label[@class='ng-tns-c46-3 ng-star-inserted']";
    private final String masterCardIcon = "//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']";
    private final String visaIcon = "//img[@src='assets/images/payment-icons/card-types/visa-system.svg']";
    private final String belkartIcon = "//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']";
    private final String mirIcon = "//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']";
    private final String buttonGooglePay = "//button[@aria-label='Google Pay']";
    private final String buttonYandexPay = "//button[@aria-label='Yandex Pay']";

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
        return driver.findElement(By.xpath(textOnlineLineTopUpNoFree)).getText();
    }

    public void clickButtonCookie() {
        try {
            driver.findElement(By.cssSelector(enterButtonCookie)).click();
        } catch (NoSuchElementException e) {

        }
    }

    public void sendInputPhoneNumber(String newNumber) {
        driver.findElement(By.xpath(inputPhoneNumber)).sendKeys(newNumber);
    }

    public void sendInputSum(String newSum) {
        driver.findElement(By.xpath(inputSum)).sendKeys(newSum);
    }

    public void clickButtonContinue() {
        driver.findElement(By.xpath(buttonContinue)).click();
    }

    public void switchToPaymentIframe() {
        WebDriverWait webDriverWait;
        WebElement iframe;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        iframe = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textPayDescription)));
        driver.switchTo().frame(iframe);
    }

    public String getDropdownText() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paymentDescription)));
        return dropdown.getText();
    }

    public List<Boolean> searchLogoImages() {
        List<String> locators = new ArrayList<>();
        locators.add(logoImageVisaCard);
        locators.add(logoImageVisaVerifiedByCard);
        locators.add(logoImageMasterCardSecureCode);
        locators.add(logoImageBelCardLocator);
        locators.add(logoImageMasterCard);

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
        return driver.findElement(By.xpath(phoneNumberInCommunicationServices)).getAttribute("placeholder");
    }

    public String getNameListOfCommunicationServices() {
        return driver.findElement(By.xpath(nameListOfCommunicationServices)).getText();
    }

    public String getSumInCommunicationServices() {
        return driver.findElement(By.xpath(sumInCommunicationServices)).getAttribute("placeholder");
    }

    public String getEmailInCommunicationServices() {
        return driver.findElement(By.xpath(emailInCommunicationServices)).getAttribute("placeholder");
    }

    public void clickButtonPopupMenu() {
        driver.findElement(By.xpath(buttonPopupMenu)).click();
    }

    public void clickHomeInternet() {
        driver.findElement(By.xpath(buttonChooseHomeInternet)).click();
    }

    public String getTextHomeInternet() {
        return driver.findElement(By.xpath(chooseHomeInternet)).getText();
    }

    public String getSubscriberNumber() {
        return driver.findElement(By.xpath(subscriberNumberOnHomeInternet)).getAttribute("placeholder");
    }

    public String getSumOnHomeInternet() {
        return driver.findElement(By.xpath(sumOnHomeInternet)).getAttribute("placeholder");
    }

    public String getEmailOnHomeInternet() {
        return driver.findElement(By.xpath(emailOnHomeInternet)).getAttribute("placeholder");
    }

    public void clickInstallmentPlan() {
        driver.findElement(By.xpath(buttonOnInstallmentPlan)).click();
    }

    public String getTextInstallmentPlan() {
        return driver.findElement(By.xpath(chooseInstallmentPlan)).getText();
    }

    public String getSubscriberNumberInInstallmentPlan() {
        return driver.findElement(By.xpath(subscriberNumberOnInstallmentPlan)).getAttribute("placeholder");
    }

    public String getSumInInstallmentPlan() {
        return driver.findElement(By.xpath(sumOnInstallmentPlan)).getAttribute("placeholder");
    }

    public String getEmailInInstallmentPlan() {
        return driver.findElement(By.xpath(emailOnInstallmentPlan)).getAttribute("placeholder");
    }

    public void clickButtonDebt() {
        driver.findElement(By.xpath(buttonDebt)).click();
    }

    public String getTextDebt() {
        return driver.findElement(By.xpath(chooseDebt)).getText();
    }

    public String getTextAccountNumber() {
        return driver.findElement(By.xpath(ACCOUNT_NUMBER_ON_DEBT)).getAttribute("placeholder");
    }

    public WebElement getTotalSumElement() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalSumElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.totalSumElement)));
        return totalSumElement;
    }

    public WebElement getPayDescription() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payDescription = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.payDescription)));
        return payDescription;
    }

    public WebElement getPayButton() {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonPay)));
        return payButton;
    }

    public WebElement getCardNumberLabel() {
        return driver.findElement(By.xpath(cardNumberLabel));
    }

    public WebElement getValidityLabel() {
        return driver.findElement(By.xpath(validityLabel));
    }

    public WebElement getCvcLabel() {
        return driver.findElement(By.xpath(cvcLabel));
    }

    public WebElement getHolderNameLabel() {
        return driver.findElement(By.xpath(holderNameLabel));
    }

    public WebElement getMastercardIcon() {
        return driver.findElement(By.xpath(masterCardIcon));
    }

    public WebElement getVisaIcon() {
        return driver.findElement(By.xpath(visaIcon));
    }

    public WebElement getBelkartIcon() {
        return driver.findElement(By.xpath(belkartIcon));
    }

    public WebElement getMirIcon() {
        return driver.findElement(By.xpath(mirIcon));
    }

    public WebElement getGooglePayButton() {
        return driver.findElement(By.xpath(buttonGooglePay));
    }

    public WebElement getYandexPayButton() {
        return driver.findElement(By.xpath(buttonYandexPay));
    }
}