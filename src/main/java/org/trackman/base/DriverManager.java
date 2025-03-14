package org.trackman.base;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.trackman.utils.ConfigReader;

import java.net.URL;

public class DriverManager {
    // Use ThreadLocal to ensure driver instances are thread-safe
    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    public static AndroidDriver initializeDriver() {
        if (driver.get() == null) {
            logger.info("..................Application starting.....................");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", ConfigReader.getProperty("mobile.platform"));
            caps.setCapability("appium:deviceName", ConfigReader.getProperty("android.deviceName"));
            caps.setCapability("appium:appActivity", ConfigReader.getProperty("android.appActivity"));
            caps.setCapability("appium:appPackage", ConfigReader.getProperty("android.appPackage"));
            caps.setCapability("appium:automationName", ConfigReader.getProperty("android.automationName"));
            caps.setCapability("appium:autoGrantPermissions", true);
            caps.setCapability("appium:platformVersion", ConfigReader.getProperty("android.platformVersion"));

            try {
                AndroidDriver androidDriver = new AndroidDriver(new URL(ConfigReader.getProperty("appium.server")), caps);
                driver.set(androidDriver);
                logger.info("................Driver initialized successfully..................");
            } catch (Exception e) {
                throw new RuntimeException("Invalid Appium Server URL: " + ConfigReader.getProperty("appium.server"), e);
            }

            Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitDriver));
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            logger.info(".........Driver quit successfully........");
        }
    }
}
