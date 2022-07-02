package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    private By deleteButton = new By.ByCssSelector(".js-delete-product-from-basket-list");
    private By titleOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__title ");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleElement() {
        List<WebElement> elements = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(titleOfProduct));
        return elements.get(0).getText();
    }
    
}
