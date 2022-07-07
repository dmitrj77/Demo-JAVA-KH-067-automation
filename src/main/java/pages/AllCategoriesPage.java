package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllCategoriesPage extends BasePage {

    private By pageTitle = new By.ByCssSelector(".page__title");

    public AllCategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get title of the page")
    public String getTitle() {
        WebElement searchPageTitle = driver.findElement(pageTitle);
        return searchPageTitle.getText();
    }

}

