import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCategoriesPage;
import pages.HomePage;

public class FunctionalityTest extends BaseTest {
    @Test(groups = {"functionality", "positive"})
    public void checkFavoriteIcon() {
        HomePage homePage = new HomePage(driver);
        AllCategoriesPage allCategoriesPage = new AllCategoriesPage(driver);
        String language = "УКР";
        homePage.setLanguage(language);
        homePage.favoriteAllCategory();
        String expectedTitleOfPage="Всі категорії";
        String actualTitleOfPage = allCategoriesPage.getTitle();
        Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
    }

}
