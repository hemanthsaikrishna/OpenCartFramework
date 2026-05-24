package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utilities.WaitUtil;

public class SearchSteps {

    SearchPage searchPage;

    @Given("User opens search application")
    public void user_opens_search_application() {

        DriverFactory.getDriver().get(
                "https://tutorialsninja.com/demo/");

        searchPage = new SearchPage(
                DriverFactory.getDriver());
    }

    @When("User enters valid product name")
    public void user_enters_valid_product_name() {

        searchPage.enterProductName("HP");
    }

    @When("User enters invalid product name")
    public void user_enters_invalid_product_name() {

        searchPage.enterProductName("abcdef");
    }

    @When("User leaves search box empty")
    public void user_leaves_search_box_empty() {

        searchPage.enterProductName("");
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {

        searchPage.clickSearchButton();
    }

    @Then("Valid product should display")
    public void valid_product_should_display() {

        WaitUtil.waitForElement(
                DriverFactory.getDriver(),
                searchPage.getValidProduct());

        Assert.assertTrue(
                searchPage.isProductDisplayed());
    }

    @Then("No product message should display")
    public void no_product_message_should_display() {

        Assert.assertTrue(
                searchPage.isNoProductMessageDisplayed());
    }

    @Then("Search results should display correctly")
    public void search_results_should_display_correctly() {

        WaitUtil.waitForElement(
                DriverFactory.getDriver(),
                searchPage.getValidProduct());

        Assert.assertTrue(
                searchPage.isProductDisplayed());
    }

    @When("User opens searched product")
    public void user_opens_searched_product() {

        WaitUtil.waitForElement(
                DriverFactory.getDriver(),
                searchPage.getValidProduct());

        searchPage.openSearchedProduct();
    }

    @Then("Product details should display successfully")
    public void product_details_should_display_successfully() {

        Assert.assertTrue(
                searchPage.isProductHeaderDisplayed());
    }
}