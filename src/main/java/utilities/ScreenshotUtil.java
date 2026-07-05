package utilities;

import driverfactory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String captureScreenshot(String screenshotName)
            throws Exception {


        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/screenshots/"
                + screenshotName
                + "_"
                + System.currentTimeMillis()
                + ".png";

        Files.copy(src.toPath(), Paths.get(path));

        return path;
    }
}