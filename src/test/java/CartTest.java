import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static pages.GiftCardPage.addedGiftCard;


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
    public void addGiftCardToCartTest() {
        HomePage homePage = new HomePage(driver);
        BuyersPage buyersPage = new BuyersPage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);

        homePage.buyersButtonClick();
        buyersPage.giftCardButtonClick();
        giftCardPage.buyButtonClick();

        Assert.assertNotNull(addedGiftCard);
    }
}
