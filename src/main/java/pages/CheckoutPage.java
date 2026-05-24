package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    By searchBox = By.name("search");

    By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    By hpProduct = By.linkText("HP LP3065");

    By addToCart = By.id("button-cart");

    By checkoutButton = By.linkText("Checkout");

    By checkoutHeading = By.xpath("//h1[contains(text(),'Checkout')]");

    By billingDetails = By.xpath("//*[contains(text(),'Billing Details')]");

    By shippingMethod = By.xpath("//*[contains(text(),'Delivery Details')]");

    By paymentMethod = By.xpath("//*[contains(text(),'Payment Method')]");

    By confirmOrderButton = By.id("button-confirm");

    public void searchProduct(String product) {

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox).sendKeys(product);
    }

    public void clickSearch() {

        driver.findElement(searchButton).click();

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }
    }

    public void addProductToCart() {

        driver.findElement(hpProduct).click();

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }

        driver.findElement(addToCart).click();

        try {

            Thread.sleep(4000);

        } catch (Exception e) {

        }
    }

    public void openCheckoutPage() {

        driver.get(
            "https://tutorialsninja.com/demo/index.php?route=checkout/cart");

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }

        driver.findElement(checkoutButton).click();

        try {

            Thread.sleep(5000);

        } catch (Exception e) {

        }
    }

    public boolean isCheckoutPageDisplayed() {

        try {

            return driver.findElement(checkoutHeading).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isBillingDetailsDisplayed() {

        try {

            return driver.findElement(billingDetails).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isShippingMethodDisplayed() {

        try {

            return driver.findElement(shippingMethod).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isPaymentMethodDisplayed() {

        try {

            return driver.findElement(paymentMethod).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isConfirmOrderButtonDisplayed() {

        try {

            Thread.sleep(5000);

            return driver.getPageSource()
                    .contains("Confirm Order");

        } catch (Exception e) {

            return false;
        }
    }
}
