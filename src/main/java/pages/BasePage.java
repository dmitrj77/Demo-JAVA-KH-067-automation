package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
