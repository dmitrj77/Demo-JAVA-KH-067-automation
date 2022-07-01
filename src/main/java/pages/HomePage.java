package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By searchButton = new By.ByCssSelector(".header-search__button.evinent-search-button");
    private By dataLangXpath = new By.ByXPath("//a[@data-lang]");
    private By searchActiveClassCss = new By.ByCssSelector(".active");


    public HomePage(WebDriver driver) {

        super(driver);
    }

    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }

    public HomePage setUkr() {
        WebElement dataLang = driver.findElement(dataLangXpath);
        WebElement searchActiveClass = driver.findElement(searchActiveClassCss);
        if (searchActiveClass.getText().equals("РУС")) {
            dataLang.click();
        }
        return new HomePage(driver);
    }

}
