import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("http://www.foxtrot.com.ua");
        driver.manage().window().maximize();
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

}

