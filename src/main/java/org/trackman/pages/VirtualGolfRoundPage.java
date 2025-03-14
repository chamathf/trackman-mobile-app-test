package org.trackman.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;


public class VirtualGolfRoundPage {

    private AndroidDriver driver;

    // Constructor to initialize the Virtual Golf Round Page with the Android driver
    public VirtualGolfRoundPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for UI elements on Virtual Golf Round Page
    private static final String MALE_TEE_BUTTON = "//android.widget.TextView[@text=\"Male Tee\"]/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text=\"%s\"]";

    private static final String FEMALE_TEE_BUTTON = "//android.widget.TextView[@text=\"Female Tee\"]/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text=\"%s\"]";

    private static final String SCORING_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";
    private static final String HOLES_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";
    private static final String PUTTING_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";

    private static final String PINS_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";

    private By mulligansToggleButton = By.id("dk.TrackMan.Range:id/switchView");
    private By courseSettingExpandButton = By.id("dk.TrackMan.Range:id/courseArrowImageView");
    private static final String WIND_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";

    private static final String FAIRWAY_BUTTON = "//android.widget.TextView[@text=\"Fairway firmness\"]/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text=\"%s\"]";

    private static final String GREEN_BUTTON = "//android.widget.TextView[@text=\"Green firmness\"]/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text=\"%s\"]";

    private static final String STIMP_BUTTON = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/titleTextView\" and @text=\"%s\"]";

    private static final By SAVE_ROUND_BUTTON = By.id("dk.TrackMan.Range:id/saveButton");

    private static final By GOLF_COURSE_NAME = By.id("dk.TrackMan.Range:id/courseNameTextView");

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private static final By BACK_KEY = By.id("dk.TrackMan.Range:id/closeButtonImageView");

    // Method to select Male Tee from available option
    public void selectMaleTee(String maleTee) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By maleTeeTileButton = By.xpath(String.format(MALE_TEE_BUTTON, maleTee));
        WebElement maleTeeElement = wait.until(ExpectedConditions.elementToBeClickable(maleTeeTileButton));
        maleTeeElement.click();

        logger.info("Selected Male Tee: " + maleTee);
    }

    // Method to select Female Tee from available option
    public void selectFemaleTee(String femaleTee) {
        By femaleTeeTileButton = By.xpath(String.format(FEMALE_TEE_BUTTON, femaleTee));

        driver.findElement(femaleTeeTileButton).click();
        logger.info("Selected Female Tee: " + femaleTee);
    }

    // Method to scroll down
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }

    // Method to select scoring from available option
    public void selectScoring(String scoring) {

        By scoringButton = By.xpath(String.format(SCORING_BUTTON, scoring));
        WebElement scoringElement = driver.findElement(scoringButton);
        scoringElement.click();
        logger.info("Selected Scoring: " + scoring);
    }

    // Method to select holes from available option
    public void selectHoles(String holes) {
        By holesButton = By.xpath(String.format(HOLES_BUTTON, holes));

        driver.findElement(holesButton).click();
        logger.info("Selected Holes: " + holes);
    }

    // Method to select putting from available option
    public void selectPutting(String putting) {
        By puttingTileButton = By.xpath(String.format(PUTTING_BUTTON, putting));

        driver.findElement(puttingTileButton).click();
        logger.info("Selected Putting : " + putting);
    }

    // Method to select pins from available option
    public void selectPins(String pins) {

        By pinsTileButton = By.xpath(String.format(PINS_BUTTON, pins));

        driver.findElement(pinsTileButton).click();
        logger.info("Selected Pins: " + pins);
    }

    // Method to expand course settings
    public void expandCourseSettings() {

        driver.findElement(courseSettingExpandButton).click();
        logger.info("Expanded Course Settings");
    }

    // Method to select wind from available option
    public void selectWind(String wind) {
        By windTileButton = By.xpath(String.format(WIND_BUTTON, wind));

        driver.findElement(windTileButton).click();
        logger.info("Selected Wind : " + wind);
    }

    // Method to allow Mulligans Toggle Button
    public void allowMulligansToggleButton(String mulligans) {
        if ("Allow".equalsIgnoreCase(mulligans)) {
            driver.findElement(mulligansToggleButton).click();
            logger.info("Mulligans Toggle Button Is Allowed");
        } else {

            logger.info("Mulligans Toggle Button Is Not Allowed");
        }

    }

    // Method to select fairway firmness from available option
    public void selectFairwayFirmness(String fairway) {
        By fairwayTileButton = By.xpath(String.format(FAIRWAY_BUTTON, fairway));

        driver.findElement(fairwayTileButton).click();
        logger.info("Selected Fairway Firmness : " + fairway);
    }

    // Method to select green firmness from available option
    public void selectGreenFirmness(String green) {
        By greenTileButton = By.xpath(String.format(GREEN_BUTTON, green));

        driver.findElement(greenTileButton).click();
        logger.info("Selected Green Firmness : " + green);
    }

    // Method to select green stimp from available option
    public void selectGreenStimp(String stimp) {
        By greenStimpTileButton = By.xpath(String.format(STIMP_BUTTON, stimp));

        driver.findElement(greenStimpTileButton).click();
        logger.info("Selected Green Stimp : " + stimp);
    }

    // Method to click save round button
    public void clickSaveRoundButton() {

        driver.findElement(SAVE_ROUND_BUTTON).click();
        logger.info("Clicked Save Round Button");
    }

    // Method to return selected visible golf course name text
    public String getGolfCourseNameText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement golfCourseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(GOLF_COURSE_NAME));
        String golfCourseNameText = golfCourseElement.getText();
        logger.info("Golf Course Name text: " + golfCourseNameText);
        return golfCourseNameText;
    }

    // Method to return selected visible hole name text
    public String getHoleNameText(String holes) {
        By holesButton = By.xpath(String.format(HOLES_BUTTON, holes));
        WebElement holeElement = driver.findElement(holesButton);
        String holeNameText = holeElement.getText();
        logger.info("Get Hole Name text: " + holeNameText);
        return holeNameText;
    }

    // Method to click black arrow button
    public void clickBlackArrowButton() {

        driver.findElement(BACK_KEY).click();
        logger.info("Clicked Back Key Button");
    }

}
