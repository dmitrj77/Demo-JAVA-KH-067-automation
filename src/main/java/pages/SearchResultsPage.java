package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByXPath("//div[@class='listing__body-wrap image-switch']//div[@class='card__body']/a[@class='card__title']");
    private By productNotFoundTitle = new By.ByCssSelector(".search-page__box-title");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickProductByIndex(int index) {
        List<WebElement> resultsWebElements = driver.findElements(results);
        wait.until(ExpectedConditions.elementToBeClickable(results));
        resultsWebElements.get(index).click();
        return new ProductPage(driver);
    }

    public String getTitleNotFound() {
        WebElement getTitle = driver.findElement(productNotFoundTitle);
        return getTitle.getText();
    }

}
