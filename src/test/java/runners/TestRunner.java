package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags= "@homePage or @logIn or @cart or @Order",
        plugin = {"json:target/cucumber-report/cucumber.json", "html:reports/cucumber-report/cucumber.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
