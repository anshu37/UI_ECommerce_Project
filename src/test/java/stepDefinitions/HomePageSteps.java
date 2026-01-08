package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.BaseStep;
import utilities.DriverFactory;

public class HomePageSteps {

    WebDriver driver;
    HomePage objHomePage;
    BaseStep BaseStepObject;

    public HomePageSteps() {
        this.driver = DriverFactory.getDriver();
        this.BaseStepObject = new BaseStep();
        this.objHomePage = new HomePage(driver);
    }

    @Given("User navigates to OpenCart home page")
    public void user_navigates_to_home_page() {

        try
        {
            if(objHomePage.navigateToHomePage())
            {
                BaseStepObject.markStepStatus("pass", "User navigated to OpenCart home page");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "User couldn't navigate to OpenCart home page");
            }
        }
        catch (Exception ex) {
            BaseStepObject.markStepStatus("fail",  "Error: User is unable to navigate to home page " + ex.getMessage());
        }
    }

    @And("User validates logo and search box are present")
    public void user_validates_logo_and_search_box()
    {

        try
        {
            if (objHomePage.validateLogoAndSearchBox())
            {
                BaseStepObject.markStepStatus("pass", "Logo and Search box are displayed");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "Logo or Search box is missing");
            }
        }
        catch (Exception ex)
        {
            BaseStepObject.markStepStatus("fail", "Error: Error while validating elements " + ex.getMessage());
        }
    }

    @Then("User validates header links are present")
    public void user_validates_header_links_are_present() {

        try {
            if (objHomePage.validateHeaderLinks()) {
                BaseStepObject.markStepStatus("pass", "Header links are displayed");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "One or more header links are missing");
            }
        }
        catch (Exception ex)
        {
            BaseStepObject.markStepStatus("fail", "Error while validating header links: " + ex.getMessage());
        }
    }

    @And("User validates footer sections are present")
    public void user_validates_footer_sections_are_present() {

        try {
            if (objHomePage.validateFooterSections())
            {
                BaseStepObject.markStepStatus("pass", "Footer sections are displayed");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "One or more footer sections are missing");
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus("fail", "Error while validating footer sections: " + ex.getMessage());
        }
    }


    @Then("User validates main menu options are displayed")
    public void user_validates_main_menu_options_are_displayed() {

        try {
            if (objHomePage.validateMainMenuOptions()) {
                BaseStepObject.markStepStatus("pass", "Main menu options are displayed");
            }
            else
            {
                BaseStepObject.markStepStatus("fail", "One or more main menu options are missing");
            }
        }
        catch (Exception ex)
        {
            BaseStepObject.markStepStatus("fail", "Error while validating main menu options: " + ex.getMessage());
        }
    }

}
