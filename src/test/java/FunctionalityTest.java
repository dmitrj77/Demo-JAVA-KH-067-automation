import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCategoriesPage;
import pages.HomePage;

public class FunctionalityTest extends BaseTest {

    @Test(groups = {"functionality","positive"})
    public void checkCompareIcon() {
        HomePage homePage = new HomePage(driver);
        AllCategoriesPage allCategoriesPage = new AllCategoriesPage(driver);
        String language = "УКР";
        homePage.setLanguage(language);
        homePage.compareAllCategory();
        Assert.assertEquals(allCategoriesPage.getTitle(), "Всі категорії");
    }

}
