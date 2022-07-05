package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashBackFoxFanPage extends BasePage {
    private By title = new By.ByXPath("//div[@class='main-title']/h4");

    public CashBackFoxFanPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        WebElement titlePage = driver.findElement(title);
        return titlePage.getText();
    }
}