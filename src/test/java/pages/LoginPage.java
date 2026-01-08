package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Reusables;

public class LoginPage {

    WebDriver driver;
    Reusables reusable;

    // ===== Page Elements =====

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(xpath = "//h2[text()='Returning Customer']")
    private WebElement returningCustomerHeading;

    // ===== Login Page Elements =====

    @FindBy(xpath ="//input[@name=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath ="//input[@name=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    // ===== Login Page Elements =====


    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    private WebElement logoutLink;



    // ===== Constructor =====

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusables(driver);
        PageFactory.initElements(driver, this);
    }

    // ===== Page Actions =====

    public boolean navigateToLoginPage() {

        myAccountDropdown.click();
        loginOption.click();
        reusable.waitForVisibility(returningCustomerHeading,10);

        return reusable.isElementPresent(returningCustomerHeading);
    }

    public boolean validateLoginPageFields() {
        return reusable.isElementPresent(returningCustomerHeading)
                && reusable.isElementPresent(emailField)
                && reusable.isElementPresent(passwordField)
                && reusable.isElementPresent(loginButton);
    }

    public boolean login(String username, String password) {

        emailField.clear();
        emailField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();

        return reusable.isElementPresent(logoutLink);
    }

    public boolean isUserLoggedIn() {
        return reusable.isElementPresent(logoutLink);
    }


    public boolean isUserLogInFailed() {
        return false;
    }
}
