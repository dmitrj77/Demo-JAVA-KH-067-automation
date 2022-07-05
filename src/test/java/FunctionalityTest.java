import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

import static utils.Category.SMARTPHONES;
import static utils.Subcategories.SMARTPHONES_APPLE;

public class FunctionalityTest extends BaseTest {
    @Test(groups = {"functionality", "positive"})
    public void sidebarPriceSorting() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);


        homePage.catalogButtonClick();
        homePage.clickSubCategory(SMARTPHONES, SMARTPHONES_APPLE);
        homePage.inputMaxPriceToSideBar("25000");
        homePage.sortProductsDesc();
        searchResultsPage.clickProductByIndex(0);
        String actualRes = productPage.getPriseOfProduct();
    }

}
