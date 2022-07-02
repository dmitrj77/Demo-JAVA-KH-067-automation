package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By dataLang = new By.ByXPath("//a[@data-lang]");
    private By searchActiveClass = new By.ByXPath("//ul[@class='header__sub-lang']//li/a[@class='active']");


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

    public HomePage setLanguage(String param) {
        WebElement dataLang = driver.findElement(this.dataLang);
        WebElement searchActiveClass = driver.findElement(this.searchActiveClass);
        if (searchActiveClass.getText().equals(param)) {
            dataLang.click();
        }
        return new HomePage(driver);
    }

}
