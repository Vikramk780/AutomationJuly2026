package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

import java.io.IOException;

public class LoginPage extends BasePage {
    WebDriver driver;
    ConfigReader configReader;
    private By userName= By.xpath("//input[@type='email']");
    private By passWord = By.xpath("//input[@type='password']");
    private By loginbtn1=By.xpath("(//button[contains(text(),'Login')])[1]");
    private By loginbtn=By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    public void enterUrl() throws IOException {
        configReader=new ConfigReader();
        driver.get(configReader.getUrl());
        click(loginbtn1);
       // driver.findElement(loginbtn1).click();
    }
    public void enterUsername(){
        type(userName,configReader.getUsername());
       //driver.findElement(userName).sendKeys(configReader.getUsername());

    }
    public void enterPassword(){
        type(passWord,configReader.getPassword());
        //driver.findElement(passWord).sendKeys(configReader.getPassword());
    }
    public void clickOnloginButton(){

        clickUsingFluentWait(loginbtn);
        //driver.findElement(loginbtn).click();
    }
    public void tearDown(){
        driver.close();
    }
}
