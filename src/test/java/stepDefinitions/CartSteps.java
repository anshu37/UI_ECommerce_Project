package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utilities.BaseStep;
import utilities.DriverFactory;

public class CartSteps {

    WebDriver driver;
    CartPage cartPage;
    BaseStep BaseStepObject;

    public CartSteps() {
        this.driver = DriverFactory.getDriver();
        this.cartPage = new CartPage(driver);
        this.BaseStepObject = new BaseStep();
    }

    @When("User searches product {string}")
    public void user_searches_product(String productName) {

        try {
            if (cartPage.searchProduct(productName)) {
                BaseStepObject.markStepStatus("pass", "User searched product: " + productName);
            } else {
                BaseStepObject.markStepStatus("fail", "Search results not displayed for product: " + productName);
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while searching product: " + ex.getMessage());
        }
    }

    @And("User adds product {string} to cart")
    public void user_adds_product_to_cart(String productName) {

        try {
            if (cartPage.addProductToCart(productName)) {
                BaseStepObject.markStepStatus("pass", productName + " added to cart successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "Failed to add product to cart: " + productName);
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while adding product to cart: " + ex.getMessage());
        }
    }

    @Then("Product should be added to cart successfully")
    public void product_should_be_added_to_cart_successfully() {

        try {
            if (cartPage.isProductAddedToCart()) {
                BaseStepObject.markStepStatus("pass", "Product is added to cart successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "Product is not added to cart");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while validating cart product: " + ex.getMessage());
        }
    }


}
