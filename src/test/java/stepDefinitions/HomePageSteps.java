package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utilities.BaseStepObject;

public class HomePageSteps {

    WebDriver driver;
    HomePage objHomePage;

    @Given("User navigates to OpenCart home page")
    public void user_navigates_to_home_page() {

        try {
            String driverPath = System.getProperty("user.dir")
                    + "/src/test/resources/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            objHomePage = new HomePage(driver);
            objHomePage.navigateToHomePage();

            BaseStepObject.startStep("User navigates to OpenCart home page");

            BaseStepObject.markStepStatus(
                    "pass",
                    "User navigated to OpenCart home page"
            );


        } catch (Exception ex) {
            BaseStepObject.markStepStatus(
                    "fail",
                    "User is unable to navigate to home page " + ex.getMessage()
            );
        }
    }

    @And("User validates logo and search box are present")
    public void user_validates_logo_and_search_box() {

        try {
            if (objHomePage.validateLogoAndSearchBox()) {
                BaseStepObject.startStep("User validates logo and search box are present");
                BaseStepObject.markStepStatus(
                        "pass",
                        "Logo and Search box are displayed"
                );
            } else {
                BaseStepObject.markStepStatus(
                        "fail",
                        "Logo or Search box is missing"
                );
            }
        } catch (Exception ex) {
            BaseStepObject.markStepStatus(
                    "fail",
                    "Error while validating elements " + ex.getMessage()
            );
        }
    }
}
