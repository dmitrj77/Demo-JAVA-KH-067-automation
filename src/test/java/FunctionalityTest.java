import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static pages.UserAgreementPage.titleUserAgreementPage;

public class FunctionalityTest extends BaseTest{

    @Test(groups = {"functionality","positive"})
    public void checkSiteTermsOfUse() {
        HomePage homePage = new HomePage(driver);

        homePage.clickTermsOfUse();
        Assert.assertNotNull(titleUserAgreementPage);
    }
}
