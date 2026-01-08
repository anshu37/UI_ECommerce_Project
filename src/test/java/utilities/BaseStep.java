package utilities;
import io.cucumber.java.BeforeStep;
import org.testng.Assert;
import reporting.ExtentManager;
import com.aventstack.extentreports.Status;

import java.util.ArrayList;
import java.util.List;

public class BaseStep extends BaseLogger{

    private static long scenarioStartTime;
    private static boolean scenarioFailed = false;

    public static long stepStartTime;
    protected static List<StepDefinitionModel> scenarioSteps = new ArrayList<>();

    public static void resetScenarioSteps() {
        scenarioSteps.clear();
    }


    public static void startScenario(String scenarioName) {
        scenarioStartTime = System.currentTimeMillis();
        scenarioFailed = false;

        System.out.println("\nStarting Scenario: " + scenarioName);
        System.out.println("============================================================");
    }

    public static void startStep(String stepName) {
        stepStartTime = System.currentTimeMillis();
        System.out.println("\nExecuting Test Step: " + stepName);
    }

    public static void markStepStatus(String status, String message) {
        long duration = (System.currentTimeMillis() - stepStartTime) / 1000;
        StepDefinitionModel step = new StepDefinitionModel();
        step.setStepSummary(message);        // or step text
        step.setStepStatus(status.toUpperCase());
        step.setStepExecutionTime(duration);
        System.out.println();

        scenarioSteps.add(step);

        if (status.equalsIgnoreCase("pass")) {
            ExtentManager.getScenario().log(Status.PASS, message);
        } else {
            scenarioFailed = true;
            ExtentManager.getScenario().log(Status.FAIL, message);

                // 🔥 THIS IS THE KEY LINE
//                throw new AssertionError(message);


        }

        System.out.println("Executing Test Step: " + message);
        System.out.println("Status: " + status.toUpperCase());
        System.out.println("Execution time in seconds: " + duration);
    }

    public static void endScenario(String scenarioName) {
        long duration = (System.currentTimeMillis() - scenarioStartTime) / 1000;
        System.out.println("\n============================================================");
        System.out.println("Finished executing : " + scenarioName);
        System.out.println("Status: " + (scenarioFailed ? "FAILED" : "PASSED"));
        System.out.println("Execution time in seconds: " + duration);
        System.out.println("============================================================\n");
//
//        if (scenarioFailed) {
//            Assert.fail("Scenario failed: " + scenarioName);
//
//        }
    }
    public static boolean isScenarioFailed() {
        return scenarioFailed;
    }

}
