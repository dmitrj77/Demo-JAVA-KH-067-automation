package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserAgreementPage extends BasePage {
    public By titleUserAgreementPage = By.xpath("//h1[@class='page__title']");

    public UserAgreementPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get title of User agreement page ")
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleUserAgreementPage));
        String title = driver.findElement(titleUserAgreementPage).getText();
        return title;
    }
}

