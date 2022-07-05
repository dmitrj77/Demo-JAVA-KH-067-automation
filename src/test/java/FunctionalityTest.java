import listener.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CashBackFoxFanPage;
import pages.HomePage;
import pages.UserAgreementPage;

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
