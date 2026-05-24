package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {

        DriverFactory.initializeBrowser();
    }

    @After
    public void tearDown() {

        DriverFactory.getDriver().quit();
    }
}