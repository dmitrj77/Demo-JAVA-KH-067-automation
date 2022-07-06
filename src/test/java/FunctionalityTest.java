import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import static utils.Category.SMARTPHONES;
import static utils.SubCategories.SMARTPHONES_APPLE;

public class FunctionalityTest extends BaseTest {

    @Test(groups = {"functionality"})
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

    @Test(groups = {"functionality", "positive"})
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

    @Test(groups = {"functionality", "positive"})
    public void checkSiteTermsOfUse() {
        HomePage homePage = new HomePage(driver);
        UserAgreementPage userAgreementPage = new UserAgreementPage(driver);

        String expectedTitle = "Умови використання сайту";

        homePage.setLanguage("УКР");
        homePage.clickTermsOfUse();
        String actualTitle = userAgreementPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups = {"functionality", "positive"})
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

    @Test(groups = {"functionality", "positive"})
    public void sidebarPriceSorting() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);


        homePage.clickCatalogButton();
        homePage.clickSubCategory(SMARTPHONES, SMARTPHONES_APPLE);
        homePage.inputMaxPriceToSideBar("25000");
        homePage.sortProductsDesc();
        searchResultsPage.clickProductByIndex(0);
        String actualRes = productPage.getPriseOfProduct();
    }
}
