package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private By title = new By.ByXPath("//h1[@class='page__title overflow']");
    private By buyButton = new By.ByCssSelector(".product-box__main-buy__button");
    private By price = new By.ByCssSelector(".product-box__main_price-wrapper");

    public ProductPage(WebDriver driver) {

        super(driver);
    }

    private WebElement getTitleElement()
    {
        return driver.findElement(title);
    }

    public String getTitle() {

        return driver.findElement(title).getText();
    }

    public CartPage buy() {
        driver.findElement(buyButton).click();
        driver.findElement(title);
        return new CartPage(driver);
    }

    public String getPriseOfProduct() {

        return driver.findElement(price).getText();
    }
}
