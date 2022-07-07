import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;


public class DeletedProductsFromCart extends BaseTest {
    @BeforeMethod
    public void BeforeMethod() {
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
        String actualText1 = cartPage.getTitles().get(0);

        homePage.search(searchCategory2);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText2 = productPage.getTitle();
        productPage.buy();
        String actualText2 = cartPage.getTitles().get(1);

        Assert.assertEquals(actualText1, expectedText1);
        Assert.assertEquals(actualText2, expectedText2);
    }

    @Description("Delete one product from cart")
    @Test
    public void deleteOneProductTest() {
        CartPage cartPage = new CartPage(driver);
        int sizeBefore = cartPage.getAmountProductsInCart();
        cartPage.clickDeleteButton();
        int sizeAfter = cartPage.getAmountProductsInCartAfterDelete();
        Assert.assertTrue(sizeAfter < sizeBefore);
    }

}

