import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("http://www.foxtrot.com.ua");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

}

