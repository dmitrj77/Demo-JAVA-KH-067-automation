package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LocatorsUtils;

import java.util.List;

public class HomePage extends BasePage {

    private By searchInput = By.cssSelector(".header-search__field");
    private By languageChoice = By.xpath("//ul[@class='header__sub-lang']//li/a");
    private By catalogButton = By.xpath("//nav[@class='header__categories-catalog js-open-catalog-mb']");
    private By cashbackIcon = new By.ByXPath("//i[contains(@class, 'icon-cashback-circle')]");
    private By detailsButton = new By.ByXPath("//div[@class='header-tooltip__nodata']//a[@data-url='L3VrL2FjY291bnQvZm94ZmFu']");
    private By buyersButton = By.xpath("//div[@class='header__sub-buyers unselectable']");

    private By compareIcon = new By.ByCssSelector(".icon-compare-2-filled");
    private By productCatalog = new By.ByXPath("//a[@class='jslink button']");
    private By favoriteIcon = new By.ByCssSelector(".header-favorite__icon.header-favorite__icon_hover.icon-heart-filled");
    private By siteTermsOfUse = By.xpath("//a[contains(@href,'1362')]");
	private By brand = By.cssSelector(".brands > li:nth-child(1) > a");
	private By best = By.cssSelector("[@id=\"main-page\"]/div[13]/div/div/div[2]/div[1]/div/div[3]/a/div/div[2]/div[1]");
	private By productCardButton = By.ByXPath("//div[@class='button card__buttons-row card__buttons-full buy-button product-buy-button']");




    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Search product: {searchQuery}")
    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        searchInputElement.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    @Step("Change language: {language}")
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

    @Step("Click catalog button")
    public HomePage clickCatalogButton() {
        driver.findElement(catalogButton).click();
        return new HomePage(driver);
    }

    @Step("Click category then subcategory: {category},{subcategory}")
    public SearchResultsPage clickSubCategory(String category, String subcategory) {
        driver.findElement(LocatorsUtils.getLinkLocator(category)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LocatorsUtils.getLinkLocator(subcategory)));
        driver.findElement(LocatorsUtils.getLinkLocator(subcategory)).click();
        return new SearchResultsPage(driver);
    }

    @Step("Go to Cashback page")
    public CashBackFoxFanPage goToCashBackPage() {
        driver.findElement(cashbackIcon).click();
        driver.findElement(detailsButton).click();
        return new CashBackFoxFanPage(driver);
    }

    @Step("Go to All category page via compare icon")
    public AllCategoriesPage compareAllCategory() {
        WebElement searchCompareIcon = driver.findElement(compareIcon);
        searchCompareIcon.click();
        WebElement searchToCatalogButton = driver.findElement(productCatalog);
        searchToCatalogButton.click();
        return new AllCategoriesPage(driver);
    }

    @Step("Search placeholder")
    public String getSearchPlaceHolder() {
        WebElement searchTitlePlaceHolder = driver.findElement(searchInput);
        return searchTitlePlaceHolder.getAttribute("placeholder");
    }

    @Step("Go to Agreement page ")
    public UserAgreementPage clickTermsOfUse() {
        Actions actionProvider = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(siteTermsOfUse));
        actionProvider.moveToElement(driver.findElement(siteTermsOfUse)).click().build().perform();
        return new UserAgreementPage(driver);
    }

    @Step("Go to All category page via Favorite icon")
        public AllCategoriesPage clickFavoriteIcon() {
        WebElement searchCompareIcon = driver.findElement(favoriteIcon);
        searchCompareIcon.click();
        WebElement searchToCatalogButton = driver.findElement(productCatalog);
        searchToCatalogButton.click();
        return new AllCategoriesPage(driver);
    }

    @Step("Go to Buyers page")
    public BuyersPage clickBuyersButton() {
        driver.findElement(buyersButton).click();
        return new BuyersPage(driver);
    }
	
	public SearchResultsPage clickBrand() {
        driver.findElement(brand).click();
        return new SearchResultsPage(driver);
    }
	
	public SearchResultsPage clickBests() {
        driver.findElement(best).click();
        return new SearchResultsPage(driver);
    }
	
	public String clickProductCardButton() {
        WebElement element = driver.findElements(productCardButton).get(0);
		element.click();
        return element.getText();
    }
	
	public ShopPage clickShop() {
		String shops = "Наші магазини по всій Україні";
        driver.findElement(shops).click();
        return new ShopPage(driver);
    }

}