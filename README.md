# TrackMan Mobile App Test Automation Framework

## Overview

TrackManMobileAppTest is a mobile test automation framework designed to verify the functionality of creating a planned round in the **TrackMan Mobile App**. This project follows the **Page Object Model (POM)** design pattern to enhance the maintainability and scalability of the test script.

## Project Structure

### 1. Base Layer (Core Utilities & Management)
This layer contains core files responsible for managing the driver, base classes, and test execution:
- **DriverManager.java**: Manages the Appium driver.
- **BaseClass.java**: Contains common functionalities for the test execution.
- **BaseTest.java**: Provides the foundation for initializing and managing the tests.

### 2. Page Object Model (POM) Layer
This layer contains classes that represent the pages in the TrackMan Mobile App:
- **LandingPage.java**: Represents the landing page of the app.
- **LoginPage.java**: Represents the login page.
- **MainPage.java**: Represents the main page of the app after login.
- **MyPlannedRoundPage.java**: Represents the "My Planned Round" page where the user creates planned rounds.
- **UserDetailsPage.java**: Represents the user details page.
- **VirtualGolfRoundPage.java**: Represents the virtual golf round creation page.

### 3. Configuration and Resource Layer
This layer includes configuration files for logging, reading properties, and other resources:
- **log4j2.xml**: Configuration for logging using Log4j2.
- **ConfigReader.java**: Reads configuration values from the properties file.
- **Properties files**: Stores Device Capabilities.

### 4. Test Data
This layer includes Test Data
- **Constants.java** 

## Technologies Used

- **Programming Language**: Java
- **Test Framework**: TestNG
- **Automation Tool**: Appium
- **Build Tool**: Maven
- **Logging**: Log4j2
- **Design Pattern**: Page Object Model (POM)

## Setup Instructions

### Prerequisites

Ensure you have the following installed on your system:
1. **Java**
2. **Maven**
3. **TestNG**
4. **Appium Server**
5. **Real Android Device** (Tested on **Vivo** device)
6. **TrackMan Mobile App** installed on the device

### Installation Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/TrackManMobileAppTest.git

2. Navigate to the project directory:
   ```sh
   cd TrackManMobileAppTest
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```
### Mobile Device Setup

Before running the tests, **connect your real Android device** and specify the device capabilities in the `config.properties` file. This is necessary to configure Appium to communicate with your Android device.

#### 1. Connect Your Android Device

- Ensure that **USB Debugging** is enabled on your device.
- Connect your device to your computer via USB.
- Run the following command to ensure your device is recognized by Appium:
  ```sh
  adb devices
- Set Device Capabilities in the config.properties File
- Start the Appium Server
  ```sh
  appium
  
## Running Tests
To execute test, use:
```sh
mvn -Dtest=PlannedRoundCreationTest test
```

## Notes
 - The app has been successfully tested on a real Android device.
 - Device Name: Vivo
 - Android Version: 12
 - All test steps have passed successfully.





  

