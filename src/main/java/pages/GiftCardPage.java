package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardPage extends BasePage {
    private By buyButton = By.xpath("//button[@class='choice__nominal_add add-gift-card']");
    public static By sumOfGiftCard = By.xpath("//span[@class='choice__cart_amount total-sum']");

    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add Gift card to cart")
    public CartPage clickBuyButton() {
        driver.findElement(buyButton).click();
        return new CartPage(driver);
    }

    @Step("Get final price of Gift cards")
    public String getSumOfGiftCard() {
        String sum = driver.findElement(sumOfGiftCard).getText();
        return sum;
    }
}

