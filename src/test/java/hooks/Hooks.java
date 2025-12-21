package hooks;

import io.cucumber.java.*;
import utilities.BaseStepObject;
import reporting.ExtentManager;


public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        BaseStepObject.startScenario(scenario.getName());
        ExtentManager.createScenario(scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        String stepName = scenario.getName(); // fallback
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Step status handled from step definition itself
    }

    @After
    public void afterScenario(Scenario scenario) {
        BaseStepObject.endScenario(scenario.getName());
        ExtentManager.flush();
    }
}
