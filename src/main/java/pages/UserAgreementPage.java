package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAgreementPage extends BasePage {
    public static By titleUserAgreementPage = By.xpath("//div[@class='contact-page__box-wrap']");

    public UserAgreementPage(WebDriver driver) {
        super(driver);
    }

}

