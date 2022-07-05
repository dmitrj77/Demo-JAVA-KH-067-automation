package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAgreementPage extends BasePage {
    public By titleUserAgreementPage = By.xpath("//h1[@class='page__title']");

    public UserAgreementPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleUserAgreementPage));
        String title = driver.findElement(titleUserAgreementPage).getText();
        return title;
    }
}

