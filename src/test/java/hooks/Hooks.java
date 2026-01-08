package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import utilities.BaseLogger;
import utilities.BaseStep;
import reporting.ExtentManager;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;


import java.nio.file.Files;
import java.nio.file.Paths;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;



public class Hooks extends BaseLogger {
    BaseStep BaseStepObject =new BaseStep();

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("Starting Execution Now");
        DriverFactory.initDriver();
        BaseStepObject.startScenario(scenario.getName());

        ExtentManager.createScenario(scenario.getName());
        BaseStep.resetScenarioSteps();
    }

    @BeforeStep
    public void beforeEachStep() {
        BaseStep.stepStartTime = System.currentTimeMillis();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Step status handled from step definition itself
    }

//    @After
//    public void afterScenario(Scenario scenario) {
//        BaseStepObject.endScenario(scenario.getName());
//
//        if (scenario.isFailed()) {
//            ExtentManager.getScenario().fail("Scenario failed");
//        } else {
//            ExtentManager.getScenario().pass("Scenario passed");
//        }
//        DriverFactory.quitDriver();
//    }
@After
public void afterScenario(Scenario scenario) {

    // ✅ RESTORE CONSOLE SUMMARY
    BaseStep.endScenario(scenario.getName());

    WebDriver driver = DriverFactory.getDriver();
    boolean failed = BaseStep.isScenarioFailed();

    if (failed && driver != null) {

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());

        if (screenshotPath != null)
        {

            ExtentManager.getScenario().addScreenCaptureFromPath(screenshotPath);

            try {
                String absolutePath = System.getProperty("user.dir") + "/reports/" + screenshotPath;

                byte[] bytes = Files.readAllBytes(Paths.get(absolutePath));
                scenario.attach(bytes, "image/png", "Failure Screenshot");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    } else {
        ExtentManager.getScenario().pass("Scenario passed");
    }

    DriverFactory.quitDriver();

    if (BaseStep.isScenarioFailed()) {
        throw new AssertionError("Scenario failed. Check failed steps above.");
    }
}





    @AfterAll
    public static void afterAllScenarios() {
        ExtentManager.flush();
    }

}
