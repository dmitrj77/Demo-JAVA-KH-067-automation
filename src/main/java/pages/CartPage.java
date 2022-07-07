package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By titlesOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__title ");
    private By searchDeleteButton = new By.ByCssSelector(".button-link.js-delete-product-from-basket-list");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get titles of products")
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
    public boolean clickDeleteButton() {
        List<String> beforeDelete = getTitles();
        List<WebElement> searchDeleteButtons = driver.findElements(searchDeleteButton);
        searchDeleteButtons.get(0).click();
        wait.until(ExpectedConditions.invisibilityOf(searchDeleteButtons.get(0)));
        List<String> afterDelete = getTitles();
        if (beforeDelete.size() == afterDelete.size() + 1) {
            return true;
        } else return false;
    }

}
