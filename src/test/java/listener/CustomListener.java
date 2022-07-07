package listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;


public class CustomListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest baseTest = (BaseTest) result.getInstance();
        WebDriver driver = baseTest.getDriver();
        takeScreenshot(driver);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        byte[] screenshotAs = scr.getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}
