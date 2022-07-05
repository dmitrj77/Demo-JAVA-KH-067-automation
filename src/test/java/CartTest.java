import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;


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

    @Test(dataProvider = "setLanguage", groups = {"positive"})
    public void changeLanguageOnSite(String language, String expectedSearchPlaceholder) {
        HomePage homePage = new HomePage(driver);

        homePage.setLanguage(language);
        String actualSearchPlaceholder = homePage.getSearchPlaceHolder();
        Assert.assertEquals(actualSearchPlaceholder, expectedSearchPlaceholder);
    }

    @Test(groups = {"positive"})
    public void addGiftCardToCartTest() {
        HomePage homePage = new HomePage(driver);
        BuyersPage buyersPage = new BuyersPage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);

        String expectedResult = "500 ₴";

        homePage.buyersButtonClick();
        buyersPage.giftCardButtonClick();
        giftCardPage.buyButtonClick();
        String actualResult = giftCardPage.getSumOfGiftCard();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
