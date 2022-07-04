import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CashBackFoxFanPage;
import pages.HomePage;

public class FunctionalityTest extends BaseTest{

    @Test(groups = {"functionality"})
    public void checkCashbackIcon(){
        HomePage homePage = new HomePage(driver);
        CashBackFoxFanPage cashBackFoxFanPage=new CashBackFoxFanPage(driver);

        String expectedLogoText = "кешбек програма";
        String language = "УКР";

        homePage.setLanguage(language);
        homePage.goToCashBackPage();
        String actualLogoText = cashBackFoxFanPage.getTitleText();

        Assert.assertEquals(actualLogoText, expectedLogoText);
    }

}
