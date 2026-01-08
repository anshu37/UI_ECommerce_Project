package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.BaseStep;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    BaseStep BaseStepObject;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.BaseStepObject = new BaseStep();
    }

    @When("User navigates to login page")
    public void user_navigates_to_login_page() {

        try
        {
            if (loginPage.navigateToLoginPage())
            {
                BaseStepObject.markStepStatus("pass", "User navigated to login page");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "Login page is not displayed");
            }
        }
        catch (Exception ex)
        {
            BaseStepObject.markStepStatus("fail", "Error while navigating to login page: " + ex.getMessage());
        }
    }

    @Then("User validates login page fields are present")
    public void user_validates_login_page_fields_are_present() {

        try {
            if (loginPage.validateLoginPageFields())
            {
                BaseStepObject.markStepStatus("pass", "Login page fields are displayed");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "One or more login page fields are missing");
            }
        }
        catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while validating login page fields: " + ex.getMessage());
        }
    }

    @When("User logs in using valid credentials")
    public void user_logs_in_using_valid_credentials() {

        try {
            String username = ConfigReader.getProperty("username");
            String password = ConfigReader.getProperty("password");

            if (loginPage.login(username, password)) {
                BaseStepObject.markStepStatus("pass", "User logged in successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "Login failed with valid credentials");
            }

        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while logging in: " + ex.getMessage());
        }
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        try {
            if (loginPage.isUserLoggedIn()) {
                BaseStepObject.markStepStatus("pass", "User is logged in successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "User is not logged in");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while validating login success: " + ex.getMessage()
            );
        }
    }


    @Then("User validates login page for failed step")
    public void userValidatesLoginPageForFailedStep() {
        try {
            if (loginPage.isUserLogInFailed()) {
                BaseStepObject.markStepStatus("pass", "User is logged in successfully");
            } else {
                BaseStepObject.markStepStatus("fail", "User is not logged in");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while validating login success: " + ex.getMessage()
            );
        }
    }
}
