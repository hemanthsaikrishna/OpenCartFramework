package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    By searchBox =
            By.name("search");

    By searchButton =
            By.xpath("//button[@class='btn btn-default btn-lg']");

    By hpProduct =
            By.linkText("HP LP3065");

    By addToCart =
            By.id("button-cart");

    public void pause() {

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }
    }

    public void searchProduct(String product) {

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox)
                .sendKeys(product);
    }

    public void clickSearch() {

        driver.findElement(searchButton)
                .click();

        pause();
    }

    public void addProductToCart() {

        driver.findElement(hpProduct)
                .click();

        pause();

        driver.findElement(addToCart)
                .click();

        pause();
    }

    public void openCheckoutPage() {

        driver.get(
                "https://tutorialsninja.com/demo/index.php?route=checkout/checkout");

        pause();

        try {

            driver.findElement(
                    By.xpath("//input[@value='guest']"))
                    .click();

            pause();

            driver.findElement(
                    By.id("button-account"))
                    .click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Guest checkout option not displayed");
        }
    }

    public void enterBillingDetails() {

        try {

            driver.findElement(
                    By.id("input-payment-firstname"))
                    .sendKeys("John");

            driver.findElement(
                    By.id("input-payment-lastname"))
                    .sendKeys("David");

            driver.findElement(
                    By.id("input-payment-email"))
                    .sendKeys(
                            "john"
                            + System.currentTimeMillis()
                            + "@gmail.com");

            driver.findElement(
                    By.id("input-payment-telephone"))
                    .sendKeys("9999999999");

            driver.findElement(
                    By.id("input-payment-address-1"))
                    .sendKeys("Kakkanad");

            driver.findElement(
                    By.id("input-payment-city"))
                    .sendKeys("Kochi");

            driver.findElement(
                    By.id("input-payment-postcode"))
                    .sendKeys("682030");

            pause();

            Select country =
                    new Select(
                            driver.findElement(
                                    By.id("input-payment-country")));

            country.selectByVisibleText("India");

            pause();

            Select state =
                    new Select(
                            driver.findElement(
                                    By.id("input-payment-zone")));

            state.selectByVisibleText("Kerala");

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Billing details not filled");
        }
    }

    public void clickBillingContinue() {

        try {

            driver.findElement(
                    By.id("button-guest"))
                    .click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Billing continue button not found");
        }
    }

    public void selectShippingMethod() {

        try {

            driver.findElement(
                    By.id("button-shipping-method"))
                    .click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Shipping method not selected");
        }
    }

    public void selectPaymentMethod() {

        try {

            driver.findElement(
                    By.name("agree"))
                    .click();

            pause();

            driver.findElement(
                    By.id("button-payment-method"))
                    .click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Payment method not selected");
        }
    }

    public void confirmOrder() {

        try {

            driver.findElement(
                    By.id("button-confirm"))
                    .click();

            pause();

        } catch (Exception e) {

            System.out.println(
                    "Confirm order button not clicked");
        }
    }
}