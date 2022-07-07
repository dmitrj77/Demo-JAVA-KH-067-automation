package pages;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By titlesOfProduct = new By.ByXPath("//div[@class='tooltip slot tooltip_active']//a[@class='header-tooltip__cards-item__title ']");
    private By searchDeleteButton = new By.ByCssSelector(".button-link.js-delete-product-from-basket-list");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        List<WebElement> titleElements = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(titlesOfProduct));
        for (WebElement element : titleElements) {
            titles.add(element.getText());
        }
        return titles;
    }

    @Description("Click delete button of cart")
    public void clickDeleteButton() {
        List<WebElement> searchDeleteButtons = driver.findElements(searchDeleteButton);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchDeleteButtons));
        searchDeleteButtons.get(0).click();
    }

    @Description("Get number of products in cart")
    public int getAmountProductsInCart() {
        List<WebElement> titleElements = driver.findElements(titlesOfProduct);
        wait.until(ExpectedConditions.visibilityOfAllElements(titleElements));
        return titleElements.size();
    }
    @Description("Get amount products in cart after delete")
    public int getAmountProductsInCartAfterDelete() {
        wait.until(ExpectedConditions.numberOfElementsToBe(titlesOfProduct,getAmountProductsInCart()-1));
        List<WebElement> titleElements = driver.findElements(titlesOfProduct);
        return titleElements.size();
    }

}
