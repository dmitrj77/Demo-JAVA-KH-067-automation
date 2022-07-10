package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByXPath("//div[@class='listing__body-wrap image-switch']//div[@class='card__body']/a[@class='card__title']");
    private By productNotFoundTitle = new By.ByCssSelector(".search-page__box-title");
    private By buyButton = new By.ByXPath("//div[@class='listing__body-wrap image-switch']//div[@class='card__buttons']/div[@data-title]");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Choose product by {index}")
    public ProductPage clickProductByIndex(int index) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(results, 0));
        List<WebElement> resultsWebElements = driver.findElements(results);
        resultsWebElements.get(index).click();
        return new ProductPage(driver);
    }

    @Step("Get title of product that not exists")
    public String getTitleNotFound() {
        WebElement getTitle = driver.findElement(productNotFoundTitle);
        return getTitle.getText();
    }

    @Step("Click buy button")
    public void clickByButton(int index) {
        List<WebElement> searchByButton = driver.findElements(buyButton);
        searchByButton.get(index).click();
    }

    @Step("Get title of buy button ")
    public String getTitleOfBuyButton(int index) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(buyButton, 4));
        List<WebElement> titles = driver.findElements(buyButton);
        return titles.get(index).getText();
    }

}
