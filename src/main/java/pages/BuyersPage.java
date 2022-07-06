package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyersPage extends BasePage {
    private By giftCardButton = By.xpath("//a[contains(@data-url,'giftcard/newindex')]");

    public BuyersPage(WebDriver driver) {
        super(driver);
    }

    public GiftCardPage clickGiftCardButton() {
        driver.findElement(giftCardButton).click();
        return new GiftCardPage(driver);
    }
}

