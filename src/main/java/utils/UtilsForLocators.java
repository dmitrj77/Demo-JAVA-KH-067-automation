package utils;

import org.openqa.selenium.By;

public class UtilsForLocators {
    public static By getLinkLocator(String sublink) {
        By xPath = By.xpath("//main[@role = 'main']//a[contains(@href,'" + sublink + "')]");
        return xPath;
    }
}
