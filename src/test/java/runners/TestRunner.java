package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags= "@login",
        plugin = {"pretty","json:target/cucumber-report/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
