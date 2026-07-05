package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
glue = {"stepdefinitions"},
        plugin = {"pretty","html:target/cucumber-reports","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/rerun.txt"}

)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        int maxThread=2;
        System.setProperty("dataproviderthreadcount",String.valueOf(maxThread));
        return super.scenarios();
    }
}
