package org.trackman.common;

public class Constants {

    // Account Settings
    public static final String EMAIL = System.getProperty("account.email", "chamathtrackman1@yopmail.com");
    public static final String PASSWORD = System.getProperty("account.password", "Test@123");

    public static final String ACCOUNT_USER_NAME = System.getProperty("account.username", "Chamath Fernando");

    // Course Settings
    public static final String COURSE_NAME = System.getProperty("course.name", "Achimer Golfclub 18-hole course");

    // Tee Settings
    public static final String MALE_TEE = System.getProperty("tee.male", "White");
    public static final String FEMALE_TEE = System.getProperty("tee.female", "Blue");

    // Round Settings
    public static final String SCORING_METHOD = System.getProperty("round.scoringMethod", "Stroke (Net)");
    public static final String HOLES = System.getProperty("round.holes", "Front 9");
    public static final String PUTTING = System.getProperty("round.putting", "Auto - Tour Pro");

    // Pins Settings
    public static final String PINS = System.getProperty("pins.setting", "Easy");

    // Mulligans Setting
    public static final String ALLOW_MULLIGANS = System.getProperty("mulligans.allow", "Allow");

    // Advanced Course Settings
    public static final String WIND = System.getProperty("course.wind", "Variable");
    public static final String FAIRWAY_FIRMNESS = System.getProperty("course.fairwayFirmness", "Hard");
    public static final String GREEN_FIRMNESS = System.getProperty("course.greenFirmness", "Soft");
    public static final String GREEN_STIMP = System.getProperty("course.greenStimp", "7 (2.1 m)");
}
