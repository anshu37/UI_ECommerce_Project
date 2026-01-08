package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Reusables;

public class OrderPage {

    WebDriver driver;
    Reusables reusable;

    // ===== Cart / Checkout Elements =====

    @FindBy(id = "cart-total")
    private WebElement cartTotal;

    @FindBy(xpath = "//strong/i[@class='fa fa-shopping-cart']/parent::strong/parent::a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/i")
    private WebElement cartButtonInHeader;

    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkoutButton;

    // ===== Checkout Page =====

    @FindBy(xpath = "//h1[text()='Checkout']")
    private WebElement checkoutHeading;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBillingButton;

    @FindBy(xpath = "(//input[@value='Continue'])[2]")
    private WebElement continueDeliveryButton;

    @FindBy(xpath = "(//input[@value='Continue'])[3]")
    private WebElement continueMethodButton;

    @FindBy(xpath = "(//input[@value='Continue'])[4]")
    private WebElement continueFinalButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeCheckbox;


    // ===== Order Success =====

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    private WebElement orderSuccessMessage;

    // ===== Order History =====

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Order History")
    private WebElement orderHistoryLink;

    @FindBy(xpath = "//h1[text()='Order History']")
    private WebElement orderHistoryHeading;

    @FindBy(xpath = "//table//td[contains(text(),'HP LP3065')]")
    private WebElement orderedProductName;

    @FindBy(xpath = "//a[@data-original-title=\"View\"]")
    private WebElement viewBtnInOrderHistory;


    // ===== Constructor =====

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusables(driver);
        PageFactory.initElements(driver, this);
    }

    // ================================
    // VALIDATIONS & ACTIONS
    // ================================

    // Check product exists in cart
    public boolean isProductPresentInCart() {
        String cartText = reusable.getElementText(cartTotal);
        return cartText != null && cartText.contains("1 item");
    }

    // Proceed to checkout
    public boolean proceedToCheckout() throws InterruptedException {

        reusable.waitAndClick(cartButtonInHeader,15);
        reusable.click(checkoutButton);
        Thread.sleep(3000);
        return reusable.isElementPresent(checkoutHeading);
    }

    // Confirm order
    public boolean confirmOrder() throws InterruptedException {

        reusable.scrollToElement(continueBillingButton);
        Thread.sleep(3000);
        reusable.waitAndClick(continueBillingButton,10);
        Thread.sleep(3000);
        reusable.waitAndClick(continueDeliveryButton,10);
        Thread.sleep(3000);
        reusable.waitAndClick(continueMethodButton,10);
        Thread.sleep(3000);
        reusable.waitAndClick(agreeCheckbox,10);
        Thread.sleep(3000);
        reusable.waitAndClick(continueFinalButton,10);
        Thread.sleep(3000);
        reusable.waitAndClick(confirmOrderButton,10);
        Thread.sleep(3000);


        return reusable.isElementPresent(orderSuccessMessage);
    }

    // Navigate to Order History
    public boolean navigateToOrderHistory() {

        reusable.click(myAccountDropdown);
        reusable.click(orderHistoryLink);

        return reusable.isElementPresent(orderHistoryHeading);
    }

    // Validate order history contains product
    public boolean isOrderPresentInHistory() {
        reusable.waitAndClick(viewBtnInOrderHistory,10);
        reusable.waitForVisibility(orderedProductName,10);
        return reusable.isElementPresent(orderedProductName);
    }
}
