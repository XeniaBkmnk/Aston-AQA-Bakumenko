package by.aston.bakumenko.ui;

import by.aston.bakumenko.pages.MtsPage;
import by.aston.bakumenko.steps.StepPage;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class MtsTest extends BaseTest {
    MtsPage mtsPage = new MtsPage();
    private static final Logger LOGGER = LogManager.getLogger();
    StepPage stepPage = new StepPage();

    @BeforeEach
    @Description("Подготовка перед выполнением каждого теста")
    public void setUp() {
        super.setUp();
        mtsPage = new MtsPage(driver);
    }

    @Test
    public void testSearchBlock() {
        stepPage.openMainByMts();
        LOGGER.info("Expected Message: " + "Онлайн пополнение\n" + "без комиссии");
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", mtsPage.getOnlineTopUpNoFeeTitle());
    }

    @Test
    public void testInputPhoneNumber() {
        stepPage.openMainByMts();
        mtsPage.sendInputPhoneNumber("297777777");
        mtsPage.sendInputSum("77");
        mtsPage.clickButtonContinue();
        mtsPage.switchToPaymentIframe();
        Assert.assertEquals(mtsPage.getDropdownText(), "Оплата: Услуги связи Номер:375297777777");
    }

    @Test
    public void testSearchLogoImagerCards() {
        stepPage.openMainByMts();
        List<Boolean> logoResult = mtsPage.searchLogoImages();
        for (Boolean result : logoResult) {
            Assert.assertTrue("Logo should be present", result);
        }
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Услуги связи'")
    public void testCheckCommunicationServiceDetails() {
        stepPage.openMainByMts();
        Assertions.assertEquals("Услуги связи", mtsPage.getNameListOfCommunicationServices());
        Assertions.assertEquals("Номер телефона", mtsPage.getPhoneNumberInCommunicationServices());
        Assertions.assertEquals("Сумма", mtsPage.getSumInCommunicationServices());
        Assertions.assertEquals("E-mail для отправки чека", mtsPage.getEmailInCommunicationServices());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Домашний интернет'")
    public void testCheckHomeInternetDetails() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickHomeInternet();
        Assertions.assertEquals("Домашний интернет", mtsPage.getTextHomeInternet());
        Assertions.assertEquals("Номер абонента", mtsPage.getSubscriberNumber());
        Assertions.assertEquals("Сумма", mtsPage.getSumOnHomeInternet());
        Assertions.assertEquals("E-mail для отправки чека", mtsPage.getEmailOnHomeInternet());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Рассрочка'")
    public void testCheckInstallmentPlan() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickInstallmentPlan();
        Assertions.assertEquals("Рассрочка", mtsPage.getTextInstallmentPlan());
        Assertions.assertEquals("Номер абонента", mtsPage.getSubscriberNumberInInstallmentPlan());
        Assertions.assertEquals("Сумма", mtsPage.getSumInInstallmentPlan());
        Assertions.assertEquals("E-mail для отправки чека", mtsPage.getEmailInInstallmentPlan());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Задолженность'")
    public void testCheckDebt() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickButtonDebt();
        Assertions.assertEquals("Задолженность", mtsPage.getTextDebt());
        Assertions.assertEquals("Номер счета на 2073", mtsPage.getTextAccountNumber());
        Assertions.assertEquals("Сумма", mtsPage.getSumInInstallmentPlan());
        Assertions.assertEquals("E-mail для отправки чека", mtsPage.getEmailOnHomeInternet());
    }

    @Test
    @Description("Заполнение полей и проверка корректности отображения информации для 'Услуги связи'")
    public void testPaymentForMobileCommunicationServices() {
        stepPage.openMainByMts();
        mtsPage.sendInputPhoneNumber("297777777");
        mtsPage.sendInputSum("77");
        mtsPage.clickButtonContinue();
        mtsPage.switchToPaymentIframe();
        Assert.assertTrue("20.00 BYN", mtsPage.getTotalSumElement().isDisplayed());
        Assert.assertTrue("Оплата: Услуги связи Номер:375297777777", mtsPage.getPayDescription().isDisplayed());
        Assert.assertTrue(" Оплатить  20.00 BYN ", mtsPage.getPayButton().isDisplayed());

        Assert.assertEquals(mtsPage.getCardNumberLabel().getText(), "Номер карты");
        Assert.assertEquals(mtsPage.getValidityLabel().getText(), "Срок действия");
        Assert.assertEquals(mtsPage.getCvcLabel().getText(), "CVC");
        Assert.assertEquals(mtsPage.getHolderNameLabel().getText(), "Имя держателя (как на карте)");

        Assert.assertTrue("mastercard", mtsPage.getMastercardIcon().isDisplayed());
        Assert.assertTrue("visa", mtsPage.getVisaIcon().isDisplayed());
        Assert.assertTrue("belkart", mtsPage.getBelkartIcon().isDisplayed());
        Assert.assertTrue("mir", mtsPage.getMirIcon().isDisplayed());

        Assert.assertTrue("Google Pay", mtsPage.getGooglePayButton().isDisplayed());
        Assert.assertTrue("Yandex Pay", mtsPage.getYandexPayButton().isDisplayed());
    }
}