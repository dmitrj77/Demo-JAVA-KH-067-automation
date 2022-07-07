import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static utils.Category.LAPTOPS;
import static utils.SubCategories.LAPTOPS_APPLE;


public class BrandsBestsTopTest extends BaseTest {
	
    @Test(groups = {"positive"})
    public void addProductFromBrandsToCartTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        int testProductIndex = 0;

        homePage.clickBrand();
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

        homePage.clickBests();
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
		
		String actualText = homePage.clickProductCardButton();                                                                                                 
		
		String expectedText = "В КОШИКУ";
		String actualText = homePage.getElement(top).getTitle();
		Assert.assertEquals(actualText, expectedText)
	}
	
    @Test(groups = {"positive"})
    public void openShopsPage() {
        HomePage homePage = new HomePage(driver);
		ShopPage shopPage = new ShopPage(driver);
		
        homePage.setLanguage("УКР");
        homePage.clickShop();
        
        String expectedText = "Магазини";
        String actualText = shopPage.getPageHeader();

        Assert.assertEquals(actualText, expectedText);
    }
}
	
	
	