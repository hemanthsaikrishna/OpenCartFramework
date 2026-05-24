package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/search.feature",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class SearchRunner extends AbstractTestNGCucumberTests {

}
