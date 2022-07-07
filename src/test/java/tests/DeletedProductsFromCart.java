package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import tests.BaseTest;


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
        productPage.buy();

        homePage.search(searchCategory2);
        searchResultsPage.clickProductByIndex(testProductIndex);
        productPage.buy();

    }

    @Description("Delete one product from cart")
    @Test
    public void deleteOneProductTest() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.clickDeleteButton());
    }

}

