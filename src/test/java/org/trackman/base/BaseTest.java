
package org.trackman.base;

import org.testng.annotations.BeforeClass;
import org.trackman.pages.*;

public class BaseTest extends BaseClass {

    // Declare the page objects for each page classes
    protected LoginPage loginPage;
    protected LandingPage landingPage;
    protected UserDetailsPage userDetailsPage;
    protected MainPage mainPage;
    protected MyPlannedRoundPage myPlannedRoundPage;
    protected VirtualGolfRoundPage virtualGolfRoundPage;

    // Initialize the page objects by passing the driver to page classes
    @BeforeClass
    public void setUpPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        userDetailsPage = new UserDetailsPage(driver);
        mainPage = new MainPage(driver);
        myPlannedRoundPage = new MyPlannedRoundPage(driver);
        virtualGolfRoundPage = new VirtualGolfRoundPage(driver);
    }
}

