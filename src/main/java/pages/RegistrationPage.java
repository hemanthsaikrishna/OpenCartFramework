package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "telephone")
    WebElement telephone;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirm")
    WebElement confirmPassword;

    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement duplicateEmailWarning;

    @FindBy(xpath = "//div[contains(text(),'First Name must be')]")
    WebElement firstNameWarning;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be')]")
    WebElement lastNameWarning;

    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear')]")
    WebElement emailWarning;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be')]")
    WebElement telephoneWarning;

    @FindBy(xpath = "//div[contains(text(),'Password must be')]")
    WebElement passwordWarning;

    public void enterFirstName(String fname) {

        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {

        lastName.sendKeys(lname);
    }

    public void enterEmail(String mail) {

        email.sendKeys(mail);
    }

    public void enterTelephone(String mobile) {

        telephone.sendKeys(mobile);
    }

    public void enterPassword(String pwd) {

        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {

        confirmPassword.sendKeys(cpwd);
    }

    public void clickPrivacyPolicy() {

        privacyPolicy.click();
    }

    public void clickContinueButton() {

        continueButton.click();
    }

    public String getDuplicateEmailWarning() {

        try {

            if(duplicateEmailWarning.isDisplayed()) {

                return duplicateEmailWarning.getText();
            }

        } catch(Exception e) {

            return "";
        }

        return "";
    }

    public boolean isFirstNameWarningDisplayed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(10));

            wait.until(ExpectedConditions
                    .visibilityOf(firstNameWarning));

            return firstNameWarning.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }

    public boolean isLastNameWarningDisplayed() {

        try {

            return lastNameWarning.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }

    public boolean isEmailWarningDisplayed() {

        try {

            return emailWarning.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }

    public boolean isTelephoneWarningDisplayed() {

        try {

            return telephoneWarning.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }

    public boolean isPasswordWarningDisplayed() {

        try {

            return passwordWarning.isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }
}