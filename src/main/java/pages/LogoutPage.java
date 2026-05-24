package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccountDropdown = By.xpath("//span[text()='My Account']");
    
    By logoutOption = By.linkText("Logout");

    By logoutHeading =
            By.xpath("//h1[contains(text(),'Account Logout')]");

    By continueButton =
            By.linkText("Continue");

    By homePageLogo =
            By.xpath("//img[@title='Your Store']");

    public void clickMyAccount() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropdown))
            .click(); 
    }

    public void clickLogout() {

        driver.findElement(logoutOption).click();
    }

    public boolean isLogoutSuccessful() {

        try {

            return driver.findElement(logoutHeading)
                    .isDisplayed();

        } catch(Exception e) {

            return false;
        }
    }

    public void clickBackButton() {

        driver.navigate().back();
    }

    public boolean isUserLoggedOut() {

        driver.navigate().refresh();

        return driver.findElements(By.linkText("Login")).size() > 0;
    }

    public void navigateToHomePage() {

        driver.findElement(continueButton).click();
    }

    public boolean isHomePageDisplayed() {

        try {

            return driver.getTitle().contains("Your Store");

        } catch (Exception e) {

            return false;
        }
    }
    
}
