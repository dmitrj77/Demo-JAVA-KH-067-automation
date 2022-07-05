import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

import static utils.Category.LAPTOPS;
import static utils.Subcategories.LAPTOPS_APPLE;


public class CartTest extends BaseTest {

    @Test(groups = {"positive"})
    public void addOneProductToCartTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String searchCategory = "Кондиціонер";
        int testProductIndex = 0;

        homePage.search(searchCategory);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText=cartPage.getTitles().get(0);

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups = {"positive"})
    public void checkFeatureButton() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        int testProductIndex = 0;

        homePage.catalogButtonClick();
        homePage.clickSubCategory(LAPTOPS, LAPTOPS_APPLE);
        searchResultsPage.clickProductByIndex(testProductIndex);
        productPage.clickFeatureButton();
        Assert.assertNotNull(productPage.getFeatureText());
    }

    @Test(dataProvider = "setLanguage", groups = {"positive"})
    public void changeLanguageOnSite(String language, String expectedSearchPlaceholder) {
        HomePage homePage = new HomePage(driver);
        homePage.setLanguage(language);
        String actualSearchPlaceholder = homePage.getSearchPlaceHolder();
        Assert.assertEquals(actualSearchPlaceholder, expectedSearchPlaceholder);
    }


    @Test(groups = {"positive"})
    public void addTwoProductsToCartTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String searchCategory1 = "Кондиціонер";
        String searchCategory2 = "Праски";
        int testProductIndex = 0;

        homePage.search(searchCategory1);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText1 = productPage.getTitle();
        productPage.buy();
        String actualText1=cartPage.getTitles().get(0);

        homePage.search(searchCategory2);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText2 = productPage.getTitle();
        productPage.buy();
        String actualText2=cartPage.getTitles().get(1);

        Assert.assertEquals(actualText1, expectedText1);
        Assert.assertEquals(actualText2, expectedText2);
    }
}
