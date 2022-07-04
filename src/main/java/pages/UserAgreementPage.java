package pages;

import org.openqa.selenium.WebDriver;

public class UserAgreementPage extends BasePage {
    public UserAgreementPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}

