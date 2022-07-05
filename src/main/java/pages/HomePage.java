package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By languageChoice = By.xpath("//ul[@class='header__sub-lang']//li/a");
    private By siteTermsOfUse = By.xpath("//a[contains(@href,'1401')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        searchInputElement.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public HomePage setLanguage(String language) {
        List<WebElement> elementList = driver.findElements(languageChoice);
        if (elementList.get(0).getText().equals(language)) {
            elementList.get(0).click();
        } else if (elementList.get(1).getText().equals(language)) {
            elementList.get(1).click();
        }
        return new HomePage(driver);
    }

    public UserAgreementPage clickTermsOfUse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteTermsOfUse));
        driver.findElement(siteTermsOfUse).click();
        return new UserAgreementPage(driver);
    }

}
