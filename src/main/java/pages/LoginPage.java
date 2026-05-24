package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement warningMessage;

    @FindBy(linkText = "Forgotten Password")
    WebElement forgotPassword;

    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    WebElement verfylogin;
    
   

    public void enterEmail(String email) {

        driver.findElement(By.name("email")).clear();

        driver.findElement(By.name("email"))
                .sendKeys(email);
    }

    public void enterPassword(String password) {

        driver.findElement(By.name("password")).clear();
        
        driver.findElement(By.name("password"))
                .sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(
                By.xpath("//input[@value='Login']")
        ).click();
    }

    public String getWarningMessage() {

        try {

            if(driver.findElement(
                    By.xpath("//div[contains(@class,'alert-danger')]"))
                    .isDisplayed()) {

                return driver.findElement(
                        By.xpath("//div[contains(@class,'alert-danger')]"))
                        .getText();
            }

        } catch(Exception e) {

            return "";
        }

        return "";
    }

    public boolean isEmailDisplayed() {

        return driver.findElement(By.name("email"))
                .isDisplayed();
    }

    public boolean isPasswordDisplayed() {

        return driver.findElement(By.name("password"))
                .isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {

        return driver.findElement(
                By.xpath("//input[@value='Login']")
        ).isDisplayed();
    }

    public boolean isForgotPasswordDisplayed() {

        return driver.findElement(
                By.linkText("Forgotten Password")
        ).isDisplayed();
    }

    public String getCurrentPageUrl() {

        return driver.getCurrentUrl();
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

    public void navigateToLoginPage() {

        driver.findElement(
                By.xpath("//span[contains(text(),'My Account')]"))
                .click();

        driver.findElement(By.linkText("Login"))
                .click();
    }
}