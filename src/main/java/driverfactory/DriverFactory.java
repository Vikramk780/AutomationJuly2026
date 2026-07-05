package driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
     WebDriver driver;
    public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

    public static WebDriver init_browser(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tl.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
             WebDriverManager.firefoxdriver().setup();
             tl.set(new FirefoxDriver());
        }else{
            System.out.println("hey you have to configure driver properly"+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       return getDriver();
    }


    public static synchronized WebDriver getDriver(){
     return tl.get();
    }
}
