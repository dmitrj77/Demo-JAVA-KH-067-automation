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
    private By catalogButton = By.xpath("//nav[@class='header__categories-catalog js-open-catalog-mb']");
    private By catalog = By.xpath("//ul[@class='catalog__category smooth-scroll']");
/*    public static By elementOfCategory = By.xpath("//main[@role = 'main']//li[@data-category='32021']");
    public static By nestedElementOfCategory = By.xpath("//main[@role = 'main']//a[contains(@href,'noutbuki_apple.html')]");*/


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
}
