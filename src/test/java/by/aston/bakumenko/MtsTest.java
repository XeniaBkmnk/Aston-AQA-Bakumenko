package by.aston.bakumenko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.testng.Assert.assertTrue;

public class MtsTest extends BaseTest {
    MtsPage mtsPage = new MtsPage();
    private static final Logger LOGGER = LogManager.getLogger();
    Step step = new Step();

    @BeforeEach
    public void setUp() {
        super.setUp();
        mtsPage = new MtsPage(driver);
    }

    @Test
    public void testSearchBlock() {
        step.openMainByMts();
        LOGGER.info("Expected Message: " + "Онлайн пополнение\n" + "без комиссии");
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", mtsPage.getOnlineTopUpNoFeeTitle());
    }

    @Test
    public void testInputPhoneNumber() {
        step.openMainByMts();
        mtsPage.sendInputPhoneNumber("297777777");
        mtsPage.sendInputSum("77");
        mtsPage.clickButtonContinue();
        mtsPage.switchToPaymentIframe();
        Assert.assertEquals(mtsPage.getDropdownText(), "Оплата: Услуги связи Номер: 375297777777");
    }

    @Test
    public void testSearchLogoImagerVisaCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerVisaCard(), "Visa logo should be present in the online top-up section");
    }

    @Test
    public void testSearchLogoImageMasterSecureСodeCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerMasterSecureCodeCard(), "Master Secure Сode card logo should be present in the online top-up section");
    }

    @Test
    public void testCheckLogoImagerMasterCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerVisaCard(), "Master card logo should be present in the online top-up section");
    }

    @Test
    public void testLogoImagerVisaVerifiedByCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerVisaVerifiedByCard(), "Visa Verified By logo should be present in the online top-up section");
    }

    @Test
    public void testLogoImagerBilCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerBilCard(), "Bel Card logo should be present in the online top-up section");
    }

    @Test
    public void testLogoImagerMasterCard() {
        step.openMainByMts();
        assertTrue(mtsPage.checkLogoImagerMasterCard(), "Master Card logo should be present in the online top-up section");
    }
}