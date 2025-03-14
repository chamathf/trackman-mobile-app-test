package org.trackman.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/main/resources/config/properties")) {
            // Load the properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unable to load config.properties file.");
        }

    }



    // Method to get a property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
