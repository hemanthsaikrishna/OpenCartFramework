package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    By searchBox = By.name("search");

    By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    By hpProduct = By.linkText("HP LP3065");

    By addToCart = By.id("button-cart");

    By quantityBox = By.xpath("//input[contains(@name,'quantity')]");

    By updateButton = By.xpath("//button[@data-original-title='Update']");

    By removeButton = By.xpath("//button[@data-original-title='Remove']");

    By emptyMessage = By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty')]");

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

    public void clickAddToCart() {

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

    public void openCart() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");

        try {

            Thread.sleep(5000);

        } catch (Exception e) {

        }
    }

	public void updateQuantity(String qty) {

        driver.findElement(quantityBox).clear();

        driver.findElement(quantityBox).sendKeys(qty);

        driver.findElement(updateButton).click();

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }
    }

    public void removeProduct() {

        driver.findElement(removeButton).click();

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

        }
    }

    public String getEmptyMessage() {

        try {

            Thread.sleep(2000);

        } catch (Exception e) {

        }

        return driver.findElement(emptyMessage).getText();
    }
}