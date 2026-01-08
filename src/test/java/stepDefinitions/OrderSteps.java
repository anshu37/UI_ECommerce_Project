package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;
import utilities.BaseStep;
import utilities.DriverFactory;

public class OrderSteps {

    WebDriver driver;
    OrderPage orderPage;
    BaseStep BaseStepObject;

    public OrderSteps() {
        this.driver = DriverFactory.getDriver();
        this.orderPage = new OrderPage(driver);
        this.BaseStepObject = new BaseStep();
    }

    // -------------------------------
    // PRE-CONDITION: PRODUCT IN CART
    // -------------------------------

    @And("User has product {string} in cart")
    public void user_has_product_in_cart(String productName) {

        try {
            if (orderPage.isProductPresentInCart()) {
                BaseStepObject.markStepStatus("pass", productName + " is present in cart");
            } else {
                BaseStepObject.markStepStatus("fail", productName + " is NOT present in cart");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error validating cart product: " + ex.getMessage());
        }
    }

    // -------------------------------
    // CONFIRM ORDER
    // -------------------------------

    @When("User confirms the order")
    public void user_confirms_the_order() {

        try {
            if (orderPage.proceedToCheckout() && orderPage.confirmOrder()) {

                BaseStepObject.markStepStatus("pass", "Order confirmed successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "Order confirmation failed");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while confirming order: " + ex.getMessage());
        }
    }


    @When("User navigates to order history")
    public void user_navigates_to_order_history() {

        try {
            if (orderPage.navigateToOrderHistory())
            {
                BaseStepObject.markStepStatus("pass", "Navigated to order history");
            } else {
                BaseStepObject.markStepStatus("fail", "Order history page not displayed");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error navigating to order history: " + ex.getMessage());
        }
    }

    @Then("Order should be visible in order history")
    public void order_should_be_visible_in_order_history() {

        try {
            if (orderPage.isOrderPresentInHistory()) {
                BaseStepObject.markStepStatus("pass", "Order is visible in order history");
            } else {
                BaseStepObject.markStepStatus("fail", "Order is NOT visible in order history");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error validating order history: " + ex.getMessage());
        }
    }
}
