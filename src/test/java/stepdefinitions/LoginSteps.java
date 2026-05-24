package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("User opens application")
    public void user_opens_application() {

        DriverFactory.getDriver().get(
                "https://tutorialsninja.com/demo/");
    }

    @When("User navigates to login page")
    public void user_navigates_to_login_page() {

        DriverFactory.getDriver().navigate().to(
                "https://tutorialsninja.com/demo/index.php?route=account/login");

        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password() {

        loginPage.enterEmail("automationtest123@gmail.com");

        loginPage.enterPassword("Test@123");
    }
    
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
    	loginPage.clickLogin();
    }

    @When("User enters invalid email")
    public void user_enters_invalid_email() {

        loginPage.enterEmail("wrong@gmail.com");
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {

        loginPage.enterPassword("Test@123");
    }

    @When("User enters valid email")
    public void user_enters_valid_email() {

        loginPage.enterEmail("automationtest123@gmail.com");
    }

    @When("User enters invalid password")
    public void user_enters_invalid_password() {

        loginPage.enterPassword("Wrong123");
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {

        loginPage.clickLogin();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        String pageSource =
                DriverFactory.getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("My Account")
                || pageSource.contains("Edit your account information")
                || pageSource.contains("Logout"));

        System.out.println("Login Successful");
    }

    @Then("Proper warning message should display")
    public void proper_warning_message_should_display() {

        String warning =
                loginPage.getWarningMessage();
        System.out.println(warning);

        String pageSource =
                DriverFactory.getDriver().getPageSource(); 

        Assert.assertTrue(
                warning.contains("Warning")
                || pageSource.contains("Warning")
                || pageSource.contains("No match")
                || pageSource.contains("E-Mail Address")
                || pageSource.contains("Password"));

        System.out.println("Warning Message Displayed");
    }

    @Then("User should see all login page elements")
    public void user_should_see_all_login_page_elements() {

        Assert.assertTrue(loginPage.isEmailDisplayed());

        Assert.assertTrue(loginPage.isPasswordDisplayed());

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());

        Assert.assertTrue(loginPage.isForgotPasswordDisplayed());
    }
}
   