package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By languageChoice = By.xpath("//ul[@class='header__sub-lang']//li/a");
    private By productCatalog = new By.ByXPath("//div[@class='tooltip slot tooltip_active']/div[@class='header-tooltip__nodata']/a");
    private By favoriteIcon = new By.ByCssSelector(".header-favorite__icon.header-favorite__icon_hover.icon-heart-filled");
    private By siteTermsOfUse = By.xpath("//a[contains(@href,'1362')]");


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
        List<WebElement> languages = driver.findElements(languageChoice);
        wait.until(ExpectedConditions.visibilityOfAllElements(languages));
        if (languages.get(0).getText().equals(language)) {
            languages.get(0).click();
        } else if (languages.get(1).getText().equals(language)) {
            languages.get(1).click();
        }
        return new HomePage(driver);
    }

    public AllCategoriesPage favoriteAllCategory() {
        WebElement searchCompareIcon = driver.findElement(favoriteIcon);
        searchCompareIcon.click();
        WebElement searchToCatalogButton = driver.findElement(productCatalog);
        searchToCatalogButton.click();
        return new AllCategoriesPage(driver);
    }

    public String getSearchPlaceHolder() {
        WebElement searchTitlePlaceHolder = driver.findElement(searchInput);
        return searchTitlePlaceHolder.getAttribute("placeholder");
    }

    public UserAgreementPage clickTermsOfUse() {
        Actions actionProvider = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteTermsOfUse));
        actionProvider.moveToElement(driver.findElement(siteTermsOfUse)).click().build().perform();
        return new UserAgreementPage(driver);
    }

}