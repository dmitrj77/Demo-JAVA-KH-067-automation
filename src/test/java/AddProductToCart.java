import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;


public class AddProductToCart extends BaseTest {

    @Test(groups = {"non-register", "positive"})
    public void addOneProductToCart() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        String search="Конденціонери";
        int index=0;

        homePage.setUkr();
        homePage.search(search);
        searchResultsPage.clickProductByIndex(index);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText = cartPage.getTitleElement();

        Assert.assertEquals(actualText, expectedText);
    }

}
