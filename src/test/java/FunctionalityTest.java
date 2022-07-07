import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.WorkWithPrice;

import static utils.Category.SMARTPHONES;
import static utils.SubCategories.SMARTPHONES_APPLE;

public class FunctionalityTest extends BaseTest {

    @Test
    public void checkCashbackIcon() {
        HomePage homePage = new HomePage(driver);
        CashBackFoxFanPage cashBackFoxFanPage = new CashBackFoxFanPage(driver);

        String expectedLogoText = "кешбек програма";
        String language = "УКР";

        homePage.setLanguage(language);
        homePage.goToCashBackPage();
        String actualLogoText = cashBackFoxFanPage.getTitleText();

        Assert.assertEquals(actualLogoText, expectedLogoText);
    }

    @Test
    public void checkCompareIcon() {
        HomePage homePage = new HomePage(driver);
        AllCategoriesPage allCategoriesPage = new AllCategoriesPage(driver);
        String language = "УКР";
        homePage.setLanguage(language);
        homePage.compareAllCategory();
        String expectedTitleOfPage = "Всі категорії";
        String actualTitleOfPage = allCategoriesPage.getTitle();
        Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
    }

    @Description("Check site terms of use")
    @Test
    public void checkSiteTermsOfUse() {
        HomePage homePage = new HomePage(driver);
        UserAgreementPage userAgreementPage = new UserAgreementPage(driver);

        String expectedTitle = "Умови використання сайту";

        homePage.setLanguage("УКР");
        homePage.clickTermsOfUse();
        String actualTitle = userAgreementPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Description("Check favorite icon")
    @Test
    public void checkFavoriteIcon() {
        HomePage homePage = new HomePage(driver);
        AllCategoriesPage allCategoriesPage = new AllCategoriesPage(driver);
        String language = "УКР";
        homePage.setLanguage(language);
        homePage.clickFavoriteIcon();
        String expectedTitle = "Всі категорії";
        String actualTitle = allCategoriesPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Description("Sort product by Max price")
    @Test
    public void sidebarPriceSorting() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String maxPrice = "25000";
        int expectedPrice = 25000;
        int indexOfProduct = 0;


        homePage.clickCatalogButton();
        homePage.clickSubCategory(SMARTPHONES, SMARTPHONES_APPLE);
        homePage.inputMaxPriceToSideBar(maxPrice);
        homePage.sortProductsDesc();
        searchResultsPage.clickProductByIndex(indexOfProduct);
        String actualResString = productPage.getPriseOfProduct();
        int actualPrice = WorkWithPrice.getintFromPrice(actualResString);

        Assert.assertTrue(expectedPrice >= actualPrice);
    }

}
