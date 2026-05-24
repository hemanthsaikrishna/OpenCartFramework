package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String name) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir")
                    + "/screenshots/" + name + ".png";

            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            return path;

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}