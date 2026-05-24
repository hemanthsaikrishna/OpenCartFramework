package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;

public class LogoutSteps extends DriverFactory {

    LogoutPage logoutPage;

    @When("User clicks on logout option")
    public void user_clicks_on_logout_option() {

        logoutPage =
                new LogoutPage(driver);

        logoutPage.clickMyAccount();

        logoutPage.clickLogout();
    }

    @Then("User should logout successfully")
    public void user_should_logout_successfully() {

        Assert.assertTrue(
                logoutPage.isLogoutSuccessful());
    }

    @And("User clicks browser back button")
    public void user_clicks_browser_back_button() {

        logoutPage.clickBackButton();
    }

    @Then("User should not access account page")
    public void user_should_not_access_account_page() {

        Assert.assertTrue(
                logoutPage.isUserLoggedOut());
    }

    @And("User navigates to home page")
    public void user_navigates_to_home_page() {

        logoutPage.navigateToHomePage();
    }

    @Then("Home page should display successfully")
    public void home_page_should_display_successfully() {

        Assert.assertTrue(
                logoutPage.isHomePageDisplayed());
    }
}