import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static utils.Category.LAPTOPS;
import static utils.SubCategories.LAPTOPS_APPLE;


public class Test extends BaseTest {
	
	@Test(groups = {"positive"})
    public void addProductFromBrandsToCartTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        int testProductIndex = 0;

		By brand = By.cssSelector(".brands > li:nth-child(1) > a");
        homePage.clickElement(brand);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText = cartPage.getTitles().get(0);

        Assert.assertEquals(actualText, expectedText);
    }
	
	@Test(groups = {"positive"})
    public void addProductFromBestsToCartTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        int testProductIndex = 0;

		By best = By.cssSelector("[@id=\"main-page\"]/div[13]/div/div/div[2]/div[1]/div/div[3]/a/div/div[2]/div[1]");
        homePage.clickElement(best);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText = cartPage.getTitles().get(0);

        Assert.assertEquals(actualText, expectedText);
    }
	
	@Test(groups = {"positive"})
    public void addProductFromTopToCartTest() {
		HomePage homePage = new HomePage(driver);
        homePage.setLanguage("УКР");
		By top = By.cssSelector("#productsOfTheWeek > div > div > div > div.card-box.card-box_5 > div.card-box__wrap.scroll-slider.scroll-slider_full.owl-carousel.owl-loaded > div.owl-stage-outer.owl-height > div > div:nth-child(1) > div > div.card-promo__footer > div.card__buttons > div");
        homePage.clickElement(top);
		
		String expectedText = "В КОШИКУ";
		String actualText = homePage.getElement(top).getTitle();
		Assert.assertEquals()
	}
	
	@Test(groups = {"positive"})
    public void openShopsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.setLanguage("РУС");
		String best = "Наши магазины по всей Украине";
        homePage.clickElement(best);
        
        String expectedText = "Магазини";
        String actualText = cartPage.getTitles().get(0);

        Assert.assertEquals(actualText, expectedText);
    }
}
	
	
	