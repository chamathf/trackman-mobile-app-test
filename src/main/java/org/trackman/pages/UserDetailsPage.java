package org.trackman.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class UserDetailsPage {
    private AndroidDriver driver;

    // Constructor to initialize the User Details Page with the Android driver
    public UserDetailsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for UI elements on User Details Page
    private By meButton = By.xpath("//android.widget.LinearLayout[@content-desc=\"Me\"]/android.widget.ImageView");
    private By accountName = By.id("dk.TrackMan.Range:id/playerFullName");
    // private Logger logger = Logger.getLogger(UserDetailsPage.class.getName());
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoginPage.class);

    // Method to click  Me button in user details
    public void clickMeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement playerFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(meButton));
        driver.findElement(meButton).click();
        logger.info("Clicked Me button");
    }

    // Method to return visible account name text
    public String getAccountNameText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountName));
        String accountNameText = accountNameElement.getText();
        logger.info("Account name text: " + accountNameText);
        return accountNameText;
    }
}
