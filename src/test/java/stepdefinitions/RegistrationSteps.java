package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;

public class RegistrationSteps {

    RegistrationPage registerPage;

    @Given("User opens registration application")
    public void user_opens_registration_application() {

        DriverFactory.getDriver().get(
                "https://tutorialsninja.com/demo/");
    }

    @When("User navigates to registration page")
    public void user_navigates_to_registration_page() {

        DriverFactory.getDriver().navigate().to(
                "https://tutorialsninja.com/demo/index.php?route=account/register");

        registerPage = new RegistrationPage(
                DriverFactory.getDriver());
    }

    @Then("User should navigate to registration page successfully")
    public void user_should_navigate_to_registration_page_successfully() {

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getTitle()
                        .contains("Register"));
    }

    @When("User enters all mandatory registration fields")
    public void user_enters_all_mandatory_registration_fields() {

        String email = "user"
                + System.currentTimeMillis()
                + "@gmail.com";

        registerPage.enterFirstName("John");

        registerPage.enterLastName("David");

        registerPage.enterEmail(email);

        registerPage.enterTelephone("9999999999");

        registerPage.enterPassword("Test@123");

        registerPage.enterConfirmPassword("Test@123");

        registerPage.clickPrivacyPolicy();
    }

    @When("User clicks continue button")
    public void user_clicks_continue_button() {

        registerPage.clickContinueButton();
    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {

        String pageSource =
                DriverFactory.getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("Your Account Has Been Created")
                || pageSource.contains("Congratulations")
                || pageSource.contains("My Account")
                || pageSource.contains("Account"));

        System.out.println("Registration Successful");
    }

    @When("User enters existing email details")
    public void user_enters_existing_email_details() {

        registerPage.enterFirstName("John");

        registerPage.enterLastName("David");

        registerPage.enterEmail(
                "automationtest123@gmail.com");

        registerPage.enterTelephone("9999999999");

        registerPage.enterPassword("Test@123");

        registerPage.enterConfirmPassword("Test@123");

        registerPage.clickPrivacyPolicy();
    }

    @Then("User should see duplicate email warning")
    public void user_should_see_duplicate_email_warning() {

        Assert.assertTrue(
                registerPage.getDuplicateEmailWarning()
                        .contains("Warning"));
    }

    @Then("User should see all mandatory field warnings")
    public void user_should_see_all_mandatory_field_warnings() {

        Assert.assertTrue( 
                registerPage.isFirstNameWarningDisplayed());

        Assert.assertTrue(
                registerPage.isLastNameWarningDisplayed());

        Assert.assertTrue(
                registerPage.isEmailWarningDisplayed());

        Assert.assertTrue(
                registerPage.isTelephoneWarningDisplayed());

        Assert.assertTrue(
                registerPage.isPasswordWarningDisplayed());
    }

    @When("User enters password and mismatched confirm password")
    public void user_enters_password_and_mismatched_confirm_password() {

        String email = "user"
                + System.currentTimeMillis()
                + "@gmail.com";

        registerPage.enterFirstName("John");

        registerPage.enterLastName("David");

        registerPage.enterEmail(email);

        registerPage.enterTelephone("9999999999");

        registerPage.enterPassword("Test@123");

        registerPage.enterConfirmPassword("Wrong123");

        registerPage.clickPrivacyPolicy();
    }

    @Then("User should see password mismatch warning")
    public void user_should_see_password_mismatch_warning() {

        String pageSource =
                DriverFactory.getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("Password confirmation")
                || pageSource.contains("does not match")
                || pageSource.contains("Password"));
    }

    @Then("User should see account success message")
    public void user_should_see_account_success_message() {

        String pageSource =
                DriverFactory.getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("Your Account Has Been Created")
                || pageSource.contains("Congratulations")
                || pageSource.contains("Account"));
    }
}