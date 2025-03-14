package org.trackman.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private AndroidDriver driver;

    //Constructor to initialize the LandingPage with the Android driver.
    public LandingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initializes the elements
    }


    // Locators for UI elements on the landing page
    private By skipButton = By.id("dk.TrackMan.Range:id/skipTextView");
    private By signInButton = By.xpath("//android.widget.Button[@resource-id=\"dk.TrackMan.Range:id/signInButton\"]");
    private static final Logger logger = LogManager.getLogger(LandingPage.class);

    //Method for skip the front screen
    public void clickSkipButton() {
        driver.findElement(skipButton).click();
        logger.info("Clicked Skip Button");
    }

    //Method for click sign in button
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
        logger.info("Clicked SignIn Button");

    }

}



