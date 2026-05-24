package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutSteps extends DriverFactory {

    CheckoutPage checkout;

    @Given("User opens checkout application")
    public void user_opens_checkout_application() {

        driver.get("https://tutorialsninja.com/demo/");
    }

    @When("User searches product for checkout")
    public void user_searches_product_for_checkout() {

        checkout = new CheckoutPage(driver);

        checkout.searchProduct("HP");

        checkout.clickSearch();
    }

    @And("User adds product for checkout")
    public void user_adds_product_for_checkout() {

        checkout.addProductToCart();
    }

    @And("User opens checkout page")
    public void user_opens_checkout_page() {

        if (checkout == null) {

            checkout = new CheckoutPage(driver);
        }

        checkout.openCheckoutPage();
    }

    @Then("Checkout page should display successfully")
    public void checkout_page_should_display_successfully() {

        Assert.assertTrue(
                checkout.isCheckoutPageDisplayed());
    }

    @Then("Billing details section should display")
    public void billing_details_section_should_display() {

        Assert.assertTrue(
                checkout.isBillingDetailsDisplayed());
    }

    @Then("Delivery details section should display")
    public void delivery_details_section_should_display() {

        Assert.assertTrue(
                checkout.isShippingMethodDisplayed());
    }

    @Then("Payment method section should display")
    public void payment_method_section_should_display() {

        Assert.assertTrue(
                checkout.isPaymentMethodDisplayed());
    }

    @Then("Confirm order button should display")
    public void confirm_order_button_should_display() {

        Assert.assertTrue(
                checkout.isConfirmOrderButtonDisplayed());
    }
}
