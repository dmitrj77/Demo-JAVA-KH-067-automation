package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By languageChoice = By.xpath("//ul[@class='header__sub-lang']//li/a");
    private By catalogButton = By.xpath("//nav[@class='header__categories-catalog js-open-catalog-mb']");
    public static By elementOfCategory = By.xpath("//main[@role = 'main']//li[@data-category='32021']");
    public static By nestedElementOfCategory = By.xpath("//main[@role = 'main']//a[contains(@href,'noutbuki_apple.html')]");

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

    public HomePage catalogButtonClick() {
        driver.findElement(catalogButton).click();
        return new HomePage(driver);
    }

    public SearchResultsPage moveToElementInElement(By first, By second) {
        Actions actionProvider = new Actions(driver);
        WebElement element = driver.findElement(first);
        WebElement iphone = driver.findElement(second);
        actionProvider.moveToElement(element).moveToElement(iphone).click().build().perform();
        return new SearchResultsPage(driver);
    }
}
