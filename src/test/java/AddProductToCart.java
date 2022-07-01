
import listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pagePackage.CartPage;
import pagePackage.HomePage;
import pagePackage.ProductPage;
import pagePackage.SearchResultsPage;


@Listeners(CustomListener.class)
public class AddProductToCart extends BaseTest {

    @Test(dataProvider = "addProductViaSearch", groups = {"non-register", "positive"})
    public void addOneProductToCart(String search, int index) {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.setUkr();
        homePage.search(search);
        searchResultsPage.clickProductByIndex(index);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText = cartPage.getTitleElement();

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups = {"addProduct", "non-register"})
    public void addTwoProductToBag() {

    }

    @Test(dataProvider = "addProductViaSearch", groups = {"addProduct", "non-register"})
    public void addProductViaSearch(String search) {

    }

    @Parameters("@search")
    @Test(groups = {"addProduct", "non-register"})
    public void addProductNonExist(@Optional("dsds") String search) {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.setUkr();
        homePage.search(search);
        String actualText = searchResultsPage.getTitleNotFound();
        String expectedText = "За запитом " + "«dsds»" + " нічого не знайдено";

        Assert.assertEquals(actualText, expectedText);

    }

}
