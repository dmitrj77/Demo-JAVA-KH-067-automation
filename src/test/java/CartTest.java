import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;


public class CartTest extends BaseTest {

    @Test(groups = {"non-register", "positive"})
    public void addOneProductToCart() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        Actions actions=new Actions(driver);

        String searchCategory = "КОНДИЦІОНЕР";
        int indexRangeOfProduct = 0;
        String param="РУС";

        homePage.setLanguage(param);
        homePage.search(searchCategory);
        searchResultsPage.clickProductByIndex(indexRangeOfProduct);
        String expectedText = productPage.getTitle();
        productPage.buy();
        String actualText = cartPage.getTitleElement();

        Assert.assertEquals(actualText, expectedText);
    }

}
