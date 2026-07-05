package pageobjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        driver= DriverFactory.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Explicit Wait
    public WebElement waitForElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Fluent Wait
    public WebElement waitForElementFluent(By locator) {
Wait<WebDriver> wait1 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        return wait1.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        waitForElementVisible(locator).click();
    }

    public void clickUsingFluentWait(By locator) {
        waitForElementFluent(locator).click();
    }

    public void type(By locator, String value) {
        waitForElementVisible(locator).clear();
        waitForElementVisible(locator).sendKeys(value);
    }

    public String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }
}
