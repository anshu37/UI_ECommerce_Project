package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Reusables {

    WebDriver driver;

    public Reusables(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

