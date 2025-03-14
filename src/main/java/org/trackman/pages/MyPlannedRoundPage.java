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

public class MyPlannedRoundPage {
    private AndroidDriver driver;

    // Constructor to initialize the Planned Round Page with the Android driver.
    public MyPlannedRoundPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for UI elements on My Planned Round page

    private By plusButton = By.id("dk.TrackMan.Range:id/addRoundButton");
    private By allTabButton = By.id("dk.TrackMan.Range:id/allChip");
    private By searchField = By.xpath("//android.widget.AutoCompleteTextView[@resource-id=\"dk.TrackMan.Range:id/search_src_text\"]");

    private By courseImageButton = By.id("dk.TrackMan.Range:id/courseImageView");

    private By closeButton = By.xpath("//android.widget.ImageView[@resource-id=\"dk.TrackMan.Range:id/closeImageView\"]");

    private By planVirtualGoldRoundButton = By.id("dk.TrackMan.Range:id/selectButton");

    private static final String SELECTED_PLANED_ROUND = "//android.widget.TextView[@resource-id=\"dk.TrackMan.Range:id/courseNameTextView\" and @text=\"%s\"]";
    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    // Method for click close button
    public void clickCloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement closeButtonAxis = wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        closeButtonAxis.click();
        logger.info("Clicked Closed Button");
    }

    // Method for click plus button
    public void clickPlusButton() {
        driver.findElement(plusButton).click();
        logger.info("Clicked Plus Button");
    }

    // Method for search courses
    public void searchCourses(String courses) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchFieldElement.sendKeys(courses);
        logger.info("Searched Course : " + courses);
    }

    // Method for click all tab button
    public void clickAllButton() {
        driver.findElement(allTabButton).click();
        logger.info("Clicked All Tab Button");
    }

    // Method for select the course
    public void selectCourse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement courseImageButtonElement = wait.until(ExpectedConditions.elementToBeClickable(courseImageButton));
        courseImageButtonElement.click();
        logger.info("Selected the Golf Course");
    }

    // Method for click plan virtual golf round
    public void clickPlanVirtualGolfRound() {
        driver.findElement(planVirtualGoldRoundButton).click();
        logger.info("Clicked Plan Virtual Golf Round Button");
    }

    // Method for get the selected planned round name
    public String getCourseCardPlannedRoundNameText(String courses) {

        By courseCardName = By.xpath(String.format(SELECTED_PLANED_ROUND, courses));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement courseCardPlannedRoundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(courseCardName));
        String courseCardPlannedRoundNameText = courseCardPlannedRoundElement.getText();
        logger.info("Get Course Card Planned Round Name text: " + courseCardPlannedRoundNameText);
        return courseCardPlannedRoundNameText;
    }
}
