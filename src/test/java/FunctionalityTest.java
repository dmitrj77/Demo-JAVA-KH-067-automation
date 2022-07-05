import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCategoriesPage;
import pages.HomePage;
import pages.UserAgreementPage;

public class FunctionalityTest extends BaseTest {
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
    public void checkSiteTermsOfUse() {
        HomePage homePage = new HomePage(driver);
        UserAgreementPage userAgreementPage = new UserAgreementPage(driver);

        String expectedTitle = "Умови використання сайту";

        homePage.setLanguage("УКР");
        homePage.clickTermsOfUse();
        String actualTitle = userAgreementPage.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
