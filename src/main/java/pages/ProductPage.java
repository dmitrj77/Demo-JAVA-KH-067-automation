package pages;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    private By title = new By.ById("product-page-title");
    private By buyButton = new By.ByCssSelector(".product-box__main-buy__button");
    private By price = new By.ByXPath("//div[@class='product-box__main_price']");
    private By featureButton = new By.ByXPath("//div[@class='product-menu__anchors smooth-scroll-extended " +
            "product-menu__anchors_static']//a[@href='#anchor-2']");
    private By featureText = new By.ByXPath("//div[@class='main-details__block']");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getTitleElement() {
        return driver.findElement(title);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public CartPage buy() {
        driver.findElement(buyButton).click();
        return new CartPage(driver);
    }

    public String getPriseOfProduct() {
        return driver.findElement(price).getText();
    }

    public ProductPage clickFeatureButton() {
        driver.findElement(featureButton).click();
        return new ProductPage(driver);
    }

    public List<WebElement> getFeatureText() {
        List<WebElement> features = driver.findElements(featureText);
        return features;
    }

    @Description("Get int from string")
    public int getIntFromString(String price) {
        String[] splitedString = price.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int k = splitedString.length - 1;
        for (int i = 0; i < k; i++) {
            stringBuilder.append(splitedString[i]);
        }
        String joinedString = stringBuilder.toString();
        int intPrice = Integer.parseInt(joinedString);
        return intPrice;
    }

}
