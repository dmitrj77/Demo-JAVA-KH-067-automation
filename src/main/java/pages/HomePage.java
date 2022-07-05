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
    private By catalogButton = By.xpath("//nav[@class='header__categories-catalog js-open-catalog-mb']");
    private By catalog = By.xpath("//ul[@class='catalog__category smooth-scroll']");
    private By priceInputFieldTo = new By.ByXPath("//input[@id='range-field-to']");
    private By sidebarSubmitButton = new By.ByXPath("//input[@type='submit']");
    private By priceDescLink = new By.ByXPath("//ul[@class='listing__body-sort']//li[@data-sort-order='PriceDesc']");
    private By scrollTopButton = new By.ByXPath("//div[@class='scroll-top-button active']");


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

    public HomePage catalogButtonClick() {
        driver.findElement(catalogButton).click();
        return new HomePage(driver);
    }

    public By getLinkLocator(String sublink) {
        By xPath = By.xpath("//main[@role = 'main']//a[contains(@href,'" + sublink + "')]");
        return xPath;
    }

    public SearchResultsPage clickSubCategory(String category, String subcategory) {
        driver.findElement(getLinkLocator(category)).click();
        wait.until(ExpectedConditions.elementToBeClickable(getLinkLocator(subcategory)));
        driver.findElement(getLinkLocator(subcategory)).click();
        return new SearchResultsPage(driver);
    }

    public String getSearchPlaceHolder() {
        WebElement searchTitlePlaceHolder = driver.findElement(searchInput);
        return searchTitlePlaceHolder.getAttribute("placeholder");
    }

    public SearchResultsPage inputMaxPriceToSideBar(String maxPrice) {
        WebElement priceInputField = driver.findElement(priceInputFieldTo);
        Actions action = new Actions(driver);
        action.doubleClick(priceInputField).build().perform();
        driver.findElement(priceInputFieldTo).sendKeys(Keys.BACK_SPACE);
        driver.findElement(priceInputFieldTo).sendKeys(maxPrice);
        driver.findElement(sidebarSubmitButton).click();
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage sortProductsDesc() {
        driver.findElement(scrollTopButton).click();
        driver.findElement(priceDescLink).click();
        return new SearchResultsPage(driver);
    }

}

