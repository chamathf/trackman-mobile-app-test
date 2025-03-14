package org.trackman.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private AndroidDriver driver;

    //Constructor to initialize the Main Page with the Android driver.
    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for UI elements on the main page
    private By mainButton = By.xpath("//android.view.ViewGroup[@resource-id=\"dk.TrackMan.Range:id/mainContainer\"]/android.widget.FrameLayout/android.widget.ImageView");
    private By plannedRoundsButton = By.xpath("//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"MY PLANNED ROUNDS\"]");
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    // Method for click golf ball icon button
    public void clickMainGolfIconButton() {
        driver.findElement(mainButton).click();
        logger.info("Clicked Main Golf Ball Icon Button");
    }

    // Method for click my planned round
    public void clickMyPlannedRounds() {
        driver.findElement(plannedRoundsButton).click();
        logger.info("Clicked My Planned Rounds");
    }
}
