package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Reusables;

public class CartPage {

    WebDriver driver;
    Reusables reusable;

    // ===== Search Elements =====

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[contains(text(),'Search')]")
    private WebElement searchResultHeading;

    // ===== Product Result Elements =====

    @FindBy(linkText = "HP LP3065")
    private WebElement hpLp3065ProductLink;

    @FindBy(xpath = "(//a[text()='HP LP3065']/ancestor::div[contains(@class,'product-thumb')]//button)[1]")
    private WebElement hpLp3065AddToCartButton;

    @FindBy(xpath = "//button[@id=\"button-cart\"]")
    private WebElement addCartBtnOfProduct;

    @FindBy(xpath ="//div[contains(@class,'alert-success') and contains(.,'Success: You have added')]\n")
    private WebElement successAlert;

    // ===== Cart Validation Elements =====

    @FindBy(id = "cart-total")
    private WebElement cartTotal;



    // ===== Constructor =====

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.reusable = new Reusables(driver);
        PageFactory.initElements(driver, this);
    }

    // ===== Page Actions =====

    public boolean searchProduct(String productName) {

        reusable.clearAndSendKeys(searchBox, productName);
        reusable.click(searchButton);

        // simple validation that search page/results loaded
        return reusable.isElementPresent(searchResultHeading);
    }

    public boolean addProductToCart(String productName) {

        // For now we handle only HP LP3065 as per requirement
        if (productName.equalsIgnoreCase("HP LP3065")) {

            reusable.scrollToElement(hpLp3065ProductLink);
            reusable.click(hpLp3065AddToCartButton);
            reusable.scrollDown();
            reusable.waitAndClick(addCartBtnOfProduct,20);
            reusable.waitForVisibility(successAlert,15);
        }

        return reusable.isElementPresent(successAlert);
    }

    public boolean isProductAddedToCart() {
        String cartText = reusable.getElementText(cartTotal);
        return cartText != null && cartText.contains("1 item");
    }

}
