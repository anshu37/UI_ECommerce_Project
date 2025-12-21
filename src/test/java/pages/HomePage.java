package pages;

import org.openqa.selenium.*;
import utilities.Reusables;

public class HomePage {

    WebDriver driver;
    Reusables reusable;

    By logo = By.cssSelector("#logo");
    By searchBox = By.name("search");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        reusable = new Reusables(driver);
    }

    public void navigateToHomePage() {
        driver.get("https://naveenautomationlabs.com/opencart/");
    }

    public boolean validateLogoAndSearchBox() {
        boolean isLogoPresent = reusable.isElementPresent(logo);
        boolean isSearchPresent = reusable.isElementPresent(searchBox);
        return isLogoPresent && isSearchPresent;
    }
}
