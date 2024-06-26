package by.aston.bakumenko;

import by.aston.bakumenko.pages.MtsPage;
import by.aston.bakumenko.steps.StepPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MtsTest extends BaseTest {
    MtsPage mtsPage = new MtsPage();
    StepPage stepPage = new StepPage();

    @BeforeMethod
    @Description("Подготовка перед выполнением каждого теста")
    public void setUp() {
        super.setUp();
        mtsPage = new MtsPage(driver);
    }

    @Test
    @Story("Проверка блока")
    public void testSearchBlock() {
        stepPage.openMainByMts();
        Assert.assertEquals("Онлайн пополнение\n" +
                "без комиссии", mtsPage.getOnlineTopUpNoFeeTitle());
    }

    @Test
    @Story("Проверка ввода номера телефона, суммы оплаты и проверра кнопки продолжить")
    @Severity(SeverityLevel.CRITICAL)
    public void testInputPhoneNumber() {
        stepPage.openMainByMts();
        mtsPage.sendInputPhoneNumber("297777777");
        mtsPage.sendInputSum("77");
        mtsPage.clickButtonContinue();
        mtsPage.switchToPaymentIframe();
        Assert.assertEquals(mtsPage.getDropdownText(), "Оплата: Услуги связи Номер:375297777777");
    }

    @Test
    @Story("Проверка логотипов карт на странице")
    public void testSearchLogoImagerCards() {
        stepPage.openMainByMts();
        List<Boolean> logoResult = mtsPage.searchLogoImages();
        for (Boolean result : logoResult) {
            Assert.assertTrue(result, "Logo should be present");
        }
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Услуги связи'")
    @Feature("Услуги связи")
    @Story("Проверка деталей")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckCommunicationServiceDetails() {
        stepPage.openMainByMts();
        Assert.assertEquals("Услуги связи", mtsPage.getNameListOfCommunicationServices());
        Assert.assertEquals("Номер телефона", mtsPage.getPhoneNumberInCommunicationServices());
        Assert.assertEquals("Сумма", mtsPage.getSumInCommunicationServices());
        Assert.assertEquals("E-mail для отправки чека", mtsPage.getEmailInCommunicationServices());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Домашний интернет'")
    @Feature("Домашний интернет")
    @Story("Проверка деталей")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckHomeInternetDetails() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickHomeInternet();
        Assert.assertEquals("Домашний интернет", mtsPage.getTextHomeInternet());
        Assert.assertEquals("Номер абонента", mtsPage.getSubscriberNumber());
        Assert.assertEquals("Сумма", mtsPage.getSumOnHomeInternet());
        Assert.assertEquals("E-mail для отправки чека", mtsPage.getEmailOnHomeInternet());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Рассрочка'")
    @Story("Проверка деталей 'Рассрочка'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckInstallmentPlan() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickInstallmentPlan();
        Assert.assertEquals("Рассрочка", mtsPage.getTextInstallmentPlan());
        Assert.assertEquals("Номер абонента", mtsPage.getSubscriberNumberInInstallmentPlan());
        Assert.assertEquals("Сумма", mtsPage.getSumInInstallmentPlan());
        Assert.assertEquals("E-mail для отправки чека", mtsPage.getEmailInInstallmentPlan());
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса 'Задолженность'")
    @Story("Проверка деталей 'Задолженность'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckDebt() {
        stepPage.openMainByMts();
        mtsPage.clickButtonPopupMenu();
        mtsPage.clickButtonDebt();
        Assert.assertEquals("Задолженность", mtsPage.getTextDebt());
        Assert.assertEquals("Номер счета на 2073", mtsPage.getTextAccountNumber());
        Assert.assertEquals("Сумма", mtsPage.getSumInInstallmentPlan());
        Assert.assertEquals("E-mail для отправки чека", mtsPage.getEmailOnHomeInternet());
    }

    @Test
    @Description("Заполнение полей и проверка корректности отображения информации для 'Услуги связи'")
    @Feature("Услуги связи")
    @Story("Проверка оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaymentForMobileCommunicationServices() {
        stepPage.openMainByMts();
        mtsPage.sendInputPhoneNumber("297777777");
        mtsPage.sendInputSum("77");
        mtsPage.clickButtonContinue();
        mtsPage.switchToPaymentIframe();
        Assert.assertTrue(mtsPage.getTotalSumElement().isDisplayed(), "20.00 BYN");
        Assert.assertTrue(mtsPage.getPayDescription().isDisplayed(), "Оплата: Услуги связи Номер:375297777777");
        Assert.assertTrue(mtsPage.getPayButton().isDisplayed(), " Оплатить  20.00 BYN ");

        Assert.assertEquals(mtsPage.getCardNumberLabel().getText(), "Номер карты");
        Assert.assertEquals(mtsPage.getValidityLabel().getText(), "Срок действия");
        Assert.assertEquals(mtsPage.getCvcLabel().getText(), "CVC");
        Assert.assertEquals(mtsPage.getHolderNameLabel().getText(), "Имя держателя (как на карте)");

        Assert.assertTrue(mtsPage.getMastercardIcon().isDisplayed(), "mastercard");
        Assert.assertTrue(mtsPage.getVisaIcon().isDisplayed(), "visa");
        Assert.assertTrue(mtsPage.getBelkartIcon().isDisplayed(), "belkart");
        Assert.assertTrue(mtsPage.getMirIcon().isDisplayed(), "mir");

        Assert.assertTrue(mtsPage.getGooglePayButton().isDisplayed(), "Google Pay");
        Assert.assertTrue(mtsPage.getYandexPayButton().isDisplayed(), "Yandex Pay");
    }
}