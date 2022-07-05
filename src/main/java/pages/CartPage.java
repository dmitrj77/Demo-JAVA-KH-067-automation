package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By titlesOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__title ");

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

}
