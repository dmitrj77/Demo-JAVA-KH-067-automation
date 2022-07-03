package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domsnapshot.model.ArrayOfStrings;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private By deleteButton = new By.ByCssSelector(".js-delete-product-from-basket-list");
    private By titleOfProduct = new By.ByCssSelector(".header-tooltip__cards-item__title ");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTitleElements() {
        List<String> stringElement = new ArrayList<>();
        List<WebElement> elements = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(titleOfProduct));
        for (WebElement element : elements) {
            stringElement.add(element.getText());
        }
        return stringElement;
    }

}
