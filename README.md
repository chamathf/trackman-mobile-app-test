# TrackMan Mobile App Test

## Overview

TrackManMobileAppTest is a mobile test automation framework designed to verify the functionality of creating a planned round in the **TrackMan Mobile App**. This project follows the **Page Object Model (POM)** design pattern to enhance the maintainability and scalability of the test scripts.

## Project Structure

### 1. Base Layer (Core Utilities & Management)
This layer contains core files responsible for managing the driver, base classes, and test execution:
- **DriverManager.java**: Manages the Appium driver.
- **BaseClass.java**: Contains common methods and functionalities for the test execution.
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
- **Properties files**: Stores environment-specific configurations.

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
1. **Java JDK 11+**
2. **Maven**
3. **Appium Server**
4. **Real Android Device** (Tested on **Vivo** device)
5. **TrackMan Mobile App** installed on the device

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

## Running Tests
To execute tests, use:
```sh
mvn test
```
Or, to run a specific test class:
```sh
mvn -Dtest=PlannedRoundCreationTest test
```

Notes
 The app has been successfully tested on a real Android device.
 Device Name: Vivo
 Android Version: 12
 All test steps have passed successfully.
pgsql
Copy
Edit


  

