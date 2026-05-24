package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/logout.feature",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class LogoutRunner extends AbstractTestNGCucumberTests {

}