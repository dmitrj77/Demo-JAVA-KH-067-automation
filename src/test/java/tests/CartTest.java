package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static utils.Category.LAPTOPS;
import static utils.SubCategories.LAPTOPS_APPLE;


public class CartTest extends BaseTest {

    @Description("Add one product to cart")
    @Test
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

    @Description("Check Feature Button")
    @Test
    public void checkFeatureButtonTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        int testProductIndex = 0;

        homePage.clickCatalogButton();
        homePage.clickSubCategory(LAPTOPS, LAPTOPS_APPLE);
        searchResultsPage.clickProductByIndex(testProductIndex);
        productPage.clickFeatureButton();

        Assert.assertNotNull(productPage.getFeatureText());
    }


    @Description("Change language on site")
    @Test
    public void changeLanguageOnSiteTest(String language, String expectedSearchPlaceholder) {
        HomePage homePage = new HomePage(driver);
        homePage.setLanguage(language);
        String actualSearchPlaceholder = homePage.getSearchPlaceHolder();
        Assert.assertEquals(actualSearchPlaceholder, expectedSearchPlaceholder);
    }


    @Description("Add Gift card to cart")
    @Test
    public void addGiftCardToCartTest() {
        HomePage homePage = new HomePage(driver);
        BuyersPage buyersPage = new BuyersPage(driver);
        GiftCardPage giftCardPage = new GiftCardPage(driver);

        String expectedResult = "500 ₴";

        homePage.clickBuyersButton();
        buyersPage.clickGiftCardButton();
        giftCardPage.clickBuyButton();
        String actualResult = giftCardPage.getSumOfGiftCard();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Description("Add two products to cart")
    @Test
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
        String actualText1 = cartPage.getTitles().get(0);

        homePage.search(searchCategory2);
        searchResultsPage.clickProductByIndex(testProductIndex);
        String expectedText2 = productPage.getTitle();
        productPage.buy();
        String actualText2 = cartPage.getTitles().get(1);

        // Assert.assertEquals(actualText1, expectedText1);
        Assert.assertEquals(actualText2, expectedText2);
    }
    @Description("Add product to cart via buy button")
    @Test
    public void addProductViaBuyButton() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        String language = "УКР";
        String searchCategory = "Кондиціонер";
        int testProductIndex = 0;
        String expectedText = "В КОШИКУ";

        homePage.setLanguage(language);
        homePage.search(searchCategory);
        searchResultsPage.clickByButton(testProductIndex);
        String actualText = searchResultsPage.getTitleOfBuyButton(testProductIndex);
        Assert.assertEquals(expectedText, actualText);
    }
}

