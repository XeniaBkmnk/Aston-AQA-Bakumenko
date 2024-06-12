package by.aston.bakumenko;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

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
    public void testSearchLogoImagerCards() {
        step.openMainByMts();
        List<Boolean> logoResult = mtsPage.searchLogoImages();
        for (Boolean result : logoResult) {
            Assert.assertTrue("Logo should be present", result);
        }
    }
}