package org.trackman.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.trackman.base.BaseTest;
import org.trackman.common.Constants;

public class PlannedRoundCreationTest extends BaseTest {

    private SoftAssert softAssert;

    // Perform the Login setup steps before each test
    @BeforeMethod
    public void setUpBeforeEachTest() {
        softAssert = new SoftAssert();

        landingPage.clickSkipButton();
        landingPage.clickSignInButton();
        loginPage.enterEmail(Constants.EMAIL);
        loginPage.enterPassword(Constants.PASSWORD);
        loginPage.clickLoginButton();
        userDetailsPage.clickMeButton();

        // Verify the user account name after login
        String accountNameText = userDetailsPage.getAccountNameText();
        softAssert.assertEquals(accountNameText, Constants.ACCOUNT_USER_NAME, "Account user name does not match the expected value.");
    }

    @Test
    public void testLoginWithValidCredentials() {
        softAssert = new SoftAssert();

        mainPage.clickMainGolfIconButton();
        mainPage.clickMyPlannedRounds();
        myPlannedRoundPage.clickCloseButton();
        myPlannedRoundPage.clickPlusButton();
        myPlannedRoundPage.clickAllButton();
        myPlannedRoundPage.searchCourses(Constants.COURSE_NAME);
        myPlannedRoundPage.selectCourse();
        myPlannedRoundPage.clickPlanVirtualGolfRound();
        virtualGolfRoundPage.selectMaleTee(Constants.MALE_TEE);
        virtualGolfRoundPage.selectFemaleTee(Constants.FEMALE_TEE);
        virtualGolfRoundPage.scrollDown();
        virtualGolfRoundPage.selectScoring(Constants.SCORING_METHOD);
        virtualGolfRoundPage.selectHoles(Constants.HOLES);
        virtualGolfRoundPage.selectPutting(Constants.PUTTING);
        virtualGolfRoundPage.scrollDown();
        virtualGolfRoundPage.selectPins(Constants.PINS);
        virtualGolfRoundPage.allowMulligansToggleButton(Constants.ALLOW_MULLIGANS);
        virtualGolfRoundPage.expandCourseSettings();
        virtualGolfRoundPage.selectWind(Constants.WIND);
        virtualGolfRoundPage.selectFairwayFirmness(Constants.FAIRWAY_FIRMNESS);
        virtualGolfRoundPage.selectGreenFirmness(Constants.GREEN_FIRMNESS);
        virtualGolfRoundPage.selectGreenStimp(Constants.GREEN_STIMP);
        virtualGolfRoundPage.clickSaveRoundButton();

        // Verify the golf course name displayed on the virtual golf round page
        String golfCourseNameText = virtualGolfRoundPage.getGolfCourseNameText();
        softAssert.assertEquals(golfCourseNameText, Constants.COURSE_NAME, "Golf course name does not match the expected value in virtual golf round page.");

        // Verify the hole name displayed on the virtual golf round page
        String holeNameText = virtualGolfRoundPage.getHoleNameText(Constants.HOLES);
        softAssert.assertEquals(holeNameText, Constants.HOLES, "Hole name does not match the expected value.");

        virtualGolfRoundPage.clickBlackArrowButton();

        // Verify that the golf course name displayed on the course card in the planned rounds section matches the expected value
        String courseCardPlannedRoundNameText = myPlannedRoundPage.getCourseCardPlannedRoundNameText(Constants.COURSE_NAME);
        softAssert.assertEquals(courseCardPlannedRoundNameText, Constants.COURSE_NAME, "Golf course name does not match the expected value in planned rounds section.");

        softAssert.assertAll();
    }
}
