package listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pagePackage.BasePage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CustomListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        BasePage basePage = (BasePage) result.getInstance();
        WebDriver driver = basePage.driver;
        byte[] screenshotBytes = takeScreenshot(driver);
        String fileName = getUniqueFileName(result.getName(), "png");
        saveFile(fileName, screenshotBytes);
    }

    public byte[] takeScreenshot(WebDriver driver) {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        byte[] screenshotAt = scr.getScreenshotAs(OutputType.BYTES);
        return screenshotAt;
    }

    public void saveFile(String filePath, byte[] file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUniqueFileName(String prefix, String format) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("[dd_MM_yyyy__HH_mm_ss]"));
        return String.format("%s_%s.%s", prefix, time, format);
    }
}
