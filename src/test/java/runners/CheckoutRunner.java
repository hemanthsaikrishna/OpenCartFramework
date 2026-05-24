package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/checkout.feature",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {

}