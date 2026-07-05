package stepdefinitions;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    ConfigReader configReader;
    @Before(order = 0)
    public void init_properties() throws IOException {
        configReader=new ConfigReader();

    }

    @Before(order = 1)
    public void init_browser(){
       DriverFactory.init_browser(configReader.getBrowser());
    }

    @After(order = 0)
    public void tearDown() {

        if(DriverFactory.getDriver() != null)
        {
            DriverFactory.getDriver().quit();
        }
    }
    @After(order = 1)
    public void getScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            try {

                // Save screenshot in folder
                ScreenshotUtil.captureScreenshot(
                        scenario.getName().replaceAll(" ", "_"));

                // Attach screenshot to Allure
                byte[] screenshot =
                        ((TakesScreenshot) DriverFactory.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failed Screenshot",
                        new ByteArrayInputStream(screenshot));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
