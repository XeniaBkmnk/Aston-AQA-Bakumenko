package by.aston.bakumenko;

public class MtsXpath {
    public static final String TEXT_ONLINE_LINE_TOP_UP_NO_FREE_LOCATOR = "//*[@id=\"pay-section\"]//h2";
    public static final String ENTER_BUTTON_COOKIE_LOCATOR = "button#cookie-agree"; //"//*[@id=\"cookie-agree\"]";
    public static final String LOGO_IMAGE_VISA_CARD_LOCATOR = "//*[@id='pay-section']//img[contains(@src, 'visa.svg')]";
    public static final String LOGO_IMAGE_VISA_VERIFIED_BY_CARD_LOCATOR = "//div[@id=\"pay-section\"]//ul/li[2]/img";
    public static final String LOGO_IMAGE_MASTER_CARD_LOCATOR = "//*[@id=\"pay-section\"]//ul/li[3]/img";
    public static final String LOGO_IMAGE_MASTER_CARD_SECURE_CODE_LOCATOR = "//div[@id=\"pay-section\"]//li[4]/img";
    public static final String LOGO_IMAGE_BEL_CARD_LOCATOR = "//*[@id=\"pay-section\"]//ul/li[5]/img";
    public static final String INPUT_PHONE_NUMBER_LOCATOR = "//*[@id=\"connection-phone\"]";
    public static final String INPUT_SUM_LOCATOR = "//*[@id=\"connection-sum\"]";
    public static final String BUTTON_CONTINUE_LOCATOR = "connection-sum";
    public static final String TEXT_PAY_DESCRIPTION_LOCATOR = "div.bepaid-app iframe"; //"body > div:nth-of-type(8) > div > iframe";  //"body > div:nth-of-type(8) > div > iframe"; //"div.bepaid-app iframe"; //"/html/body/app-root/div/div ";  // /html/body/app-root/div/div //"div.pay__partners"; //"li"; // "pay__partners";  //"//[@id=\"pay-connection\"]/div[1]/label";   //"/html/body/app-root/div/div/div/app-payment-container/section/div/div/span";   //"//*[@id=\"pay-connection\"]/div[1]/label" + "//*[@id=\"connection-phone\"]";       //"connection-phone";    //"//p[@class='header__payment-info']";  //"//*[@class='pay-description__text']";
    public static final String EXPECTED_PAY_DESCRIPTION = "Оплата: Услуги связи Номер: 375297777777";
    public static final String PAYMENT_DESCRIPTION_LOCATOR = "span.pay-description__text";
}
