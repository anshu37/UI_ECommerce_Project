package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Reusables;
import utilities.ConfigReader;

public class HomePage {

    WebDriver driver;
    Reusables reusable;

    // ===== Page Elements =====

    @FindBy(xpath = "//div[@id='logo']/a/img")
    private WebElement logo;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBox;

    // ===== Header Elements =====

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[contains(@title, 'Wish List')]")
    private WebElement wishListLink;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//a[@title='Checkout']")
    private WebElement checkoutLink;

    // ===== Footer Section Headings =====

    @FindBy(xpath = "//footer//h5[text()='Information']")
    private WebElement informationSection;

    @FindBy(xpath = "//footer//h5[text()='Customer Service']")
    private WebElement customerServiceSection;

    @FindBy(xpath = "//footer//h5[text()='Extras']")
    private WebElement extrasSection;

    @FindBy(xpath = "//footer//h5[text()='My Account']")
    private WebElement myAccountFooterSection;

    // ===== Main Menu Options =====

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Desktops']")
    private WebElement desktopsMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Laptops & Notebooks']")
    private WebElement laptopsMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Components']")
    private WebElement componentsMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Tablets']")
    private WebElement tabletsMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Software']")
    private WebElement softwareMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Phones & PDAs']")
    private WebElement phonesMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='Cameras']")
    private WebElement camerasMenu;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[text()='MP3 Players']")
    private WebElement mp3PlayersMenu;




    // ===== Constructor =====

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusables(driver);
        PageFactory.initElements(driver, this);
    }

    // ===== Page Actions =====

    public boolean navigateToHomePage() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        return reusable.isElementPresent(logo);
    }

    // ===== Validations =====

    public boolean validateLogoAndSearchBox() {
        return reusable.isElementPresent(logo) && reusable.isElementPresent(searchBox);
    }

    public boolean validateHeaderLinks() {
        reusable.waitForVisibility(myAccountLink,5);
        reusable.waitForVisibility(wishListLink,5);
        reusable.waitForVisibility(shoppingCartLink,5);
        reusable.waitForVisibility(checkoutLink,5);
        return reusable.isElementPresent(myAccountLink)
                && reusable.isElementPresent(wishListLink)
                && reusable.isElementPresent(shoppingCartLink)
                && reusable.isElementPresent(checkoutLink);
    }

    public boolean validateFooterSections() {
        return reusable.isElementPresent(informationSection)
                && reusable.isElementPresent(customerServiceSection)
                && reusable.isElementPresent(extrasSection)
                && reusable.isElementPresent(myAccountFooterSection);
    }

    public boolean validateMainMenuOptions() {
        return reusable.isElementPresent(desktopsMenu)
                && reusable.isElementPresent(laptopsMenu)
                && reusable.isElementPresent(componentsMenu)
                && reusable.isElementPresent(tabletsMenu)
                && reusable.isElementPresent(softwareMenu)
                && reusable.isElementPresent(phonesMenu)
                && reusable.isElementPresent(camerasMenu)
                && reusable.isElementPresent(mp3PlayersMenu);
    }

}
