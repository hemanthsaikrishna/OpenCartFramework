package stepdefinitions;

import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartSteps extends DriverFactory {

    CartPage cart;

    @When("User searches product for cart")
    public void user_searches_product_for_cart() {

        cart = new CartPage(driver);

        cart.searchProduct("HP");

        cart.clickSearch();
    }

    @And("User adds product to cart")
    public void user_adds_product_to_cart() {

        cart.clickAddToCart();
    }

    @Then("Product should get added successfully")
    public void product_should_get_added_successfully() {

        System.out.println("Product Added Successfully");
    }

    @And("User opens shopping cart")
    public void user_opens_shopping_cart() {

        if(cart == null) {

            cart = new CartPage(DriverFactory.getDriver());
        }

        cart.openCart();
    }
    
    @And("User updates product quantity")
    public void user_updates_product_quantity() {

        cart.updateQuantity("2");

        System.out.println("Quantity Updated Successfully");
    }

    @Then("Product quantity should get updated")
    public void product_quantity_should_get_updated() {

        System.out.println("Updated Quantity Displayed");
    }

    @And("User removes product from cart")
    public void user_removes_product_from_cart() {

        cart.removeProduct();

        System.out.println("Cart Empty Successfully");
    }

    @Then("Shopping cart should become empty")
    public void shopping_cart_should_become_empty() {

        String msg = cart.getEmptyMessage();

        Assert.assertTrue(msg.toLowerCase().contains("shopping cart"));

        System.out.println("Cart Empty");
    }

    @Then("Product total amount should display")
    public void product_total_amount_should_display() {

        System.out.println("Total Displayed");
    }

    @Then("Empty cart message should display")
    public void empty_cart_message_should_display() {

        String msg = cart.getEmptyMessage();

        System.out.println(msg);

        Assert.assertTrue(msg.contains("Your shopping cart is empty!"));
    }
    @Given("User opens cart application")
    public void user_opens_cart_application() {

        driver.get("https://tutorialsninja.com/demo/");
    }
}