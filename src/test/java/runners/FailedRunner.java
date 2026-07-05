package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/rerun.txt",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/failed-cucumber-report",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}