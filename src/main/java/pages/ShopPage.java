package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.LocatorsUtils;

import java.util.List;

public class ShopPage extends BasePage {

    public ShopPage(WebDriver driver) {
        super(driver);
    }
	
	public String getPageHeader() {
		WebElement header = driver.findElement(By.tagName("h1"));
		return header.getText();
    }

}