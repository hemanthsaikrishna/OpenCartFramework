package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//div[@id='search']//button")
    WebElement searchButton;

    @FindBy(linkText = "HP LP3065")
    WebElement validProduct;

    @FindBy(xpath = "//p[contains(text(),'There is no product')]")
    WebElement noProductMessage;

    @FindBy(linkText = "HP LP3065")
    WebElement searchedProduct;

    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement productHeader;

    public void enterProductName(String product) {

        searchBox.clear();

        searchBox.sendKeys(product);
    }

    public void clickSearchButton() {

        searchButton.click();
    }

    public boolean isProductDisplayed() {

        return validProduct.isDisplayed();
    }

    public boolean isNoProductMessageDisplayed() {

        return noProductMessage.isDisplayed();
    }

    public void openSearchedProduct() {

        searchedProduct.click();
    }

    public boolean isProductHeaderDisplayed() {

        return productHeader.isDisplayed();
    }

    public WebElement getValidProduct() {

        return validProduct;
    }
}