import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

import static utils.CategoryList.LAPTOPS;
import static utils.SubcategoriesList.LAPTOPS_APPLE;


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
        String actualText = cartPage.getTitles().get(0);

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
        productPage.featureButtonClick();
        Assert.assertNotNull(productPage.getFeatureText());
    }
}
