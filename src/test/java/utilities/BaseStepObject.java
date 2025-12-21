package utilities;
import reporting.ExtentManager;
import com.aventstack.extentreports.Status;

public class BaseStepObject {

    private static long stepStartTime;
    private static long scenarioStartTime;
    private static boolean scenarioFailed = false;

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
        System.out.println("Status: " + status.toUpperCase());
        System.out.println("Execution time in seconds: " + duration);

        if (status.equalsIgnoreCase("pass")) {
            ExtentManager.getScenario().log(Status.PASS, message);
        } else {
            scenarioFailed = true;
            ExtentManager.getScenario().log(Status.FAIL, message);
        }
    }

    public static void endScenario(String scenarioName) {
        long duration = (System.currentTimeMillis() - scenarioStartTime) / 1000;
        System.out.println("\n============================================================");
        System.out.println("Finished executing : " + scenarioName);
        System.out.println("Status: " + (scenarioFailed ? "FAILED" : "PASSED"));
        System.out.println("Execution time in seconds: " + duration);
        System.out.println("============================================================\n");
    }
}
