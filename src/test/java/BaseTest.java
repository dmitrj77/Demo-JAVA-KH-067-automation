import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.time.Duration;

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
    @DataProvider(name = "addProductViaSearch")
    public Object[][] createData() {
        return new Object[][]{
                {"Конденціонери", 0},
                {"Праски", 3},
        };
    }

}

