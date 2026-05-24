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

        checkout = new CheckoutPage(driver);
    }

    @When("User searches product for checkout")
    public void user_searches_product_for_checkout() {

        checkout.searchProduct("HP");

        checkout.clickSearch();
    }

    @And("User adds product for checkout")
    public void user_adds_product_for_checkout() {

        checkout.addProductToCart();
    }

    @And("User opens checkout page")
    public void user_opens_checkout_page() {

        checkout.openCheckoutPage();
    }

    @And("User enters billing details")
    public void user_enters_billing_details() {

        checkout.enterBillingDetails();

        checkout.clickBillingContinue();
    }

    @And("User selects shipping method")
    public void user_selects_shipping_method() {

        checkout.selectShippingMethod();
    }

    @And("User selects payment method")
    public void user_selects_payment_method() {

        checkout.selectPaymentMethod();
    }

    @And("User confirms order")
    public void user_confirms_order() {

        checkout.confirmOrder();
    }

    @Then("Order should get confirmed successfully")
    public void order_should_get_confirmed_successfully() {

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Your order has been placed")
                ||
                driver.getCurrentUrl()
                        .contains("success"));
    }
}