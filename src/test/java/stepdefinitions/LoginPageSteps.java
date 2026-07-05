package stepdefinitions;

import driverfactory.DriverFactory;
import pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.io.IOException;

public class LoginPageSteps {
  LoginPage loginPageRef;
        @Given("enter login page url")
    public void enter_login_page_url() throws IOException {
        loginPageRef=new LoginPage(DriverFactory.getDriver());
        loginPageRef.enterUrl();
    }
    @Then("enter username")
    public void enter_username() {
        loginPageRef.enterUsername();
    }
    @Then("enter password")
    public void enter_password() {
        loginPageRef.enterPassword();
    }
    @Then("click on login button")
    public void click_on_login_button() {
      loginPageRef.clickOnloginButton();
      loginPageRef.tearDown();
    }

}
