package org.trackman.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;

    //Constructor to initialize the LandingPage with the Android driver.
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for UI elements on the login page
    private By EmailField = By.xpath("//android.widget.EditText[@resource-id=\"Email\"]");
    private By passwordField = By.xpath("//android.widget.EditText[@resource-id=\"Password\"]");
    private By loginButton = By.xpath("//android.widget.Button[@text=\"SIGN IN\"]");
    private By dashboard = By.id("com.example.app:id/dashboard");

    private By playerNameField = By.xpath("//android.widget.EditText[@resource-id=\"Nickname\"]");


    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    // Method for Enter Email
    public void enterEmail(String email) {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement emailFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(EmailField));
        emailFieldElement.sendKeys(email);
        logger.info("Entered the Email : " + email);
    }

    // Method for Enter Password
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordFieldElement.sendKeys(password);
        logger.info("Entered the Password : " + password);
    }


    // Method for Click Login Button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        logger.info("Clicked Login Button");
    }

}
