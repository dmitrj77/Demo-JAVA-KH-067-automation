import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FunctionalityTest extends BaseTest{

    @Test(groups = {"functionality","positive"})
    public void checkSiteTermsOfUse() {
        HomePage homePage = new HomePage(driver);
        UserAgreementPage userAgreementPage = new UserAgreementPage(driver);

        String expectedUrl = "https://www.foxtrot.com.ua/uk/article/1401";

        homePage.siteTermsOfUseClick();
        Assert.assertEquals(userAgreementPage.getUrl(), expectedUrl);
    }
}
