package org.trackman.base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
    protected AndroidDriver driver;

    //This Method use for  initialize the driver using DriverManager
    @BeforeClass
    public void setUp() {
        driver = DriverManager.initializeDriver();
    }

    // This Method use for Quit the driver after all the tests have finished
    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}


