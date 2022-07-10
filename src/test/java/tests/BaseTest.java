package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.CustomListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(CustomListener.class)
public class BaseTest {
    protected WebDriver driver;


    @BeforeSuite
    public void webDriverManagerSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://www.foxtrot.com.ua");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @DataProvider(name = "siteLanguages")
    public Object[][] getLanguages() {
        return new Object[][]{
                {"УКР", "Я шукаю ..."},
                {"РУС", "Я ищу ..."},
        };
    }

    public WebDriver getDriver() {
        return driver;
    }


}
