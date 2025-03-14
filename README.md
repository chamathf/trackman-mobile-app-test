# trackman-mobile-app-test
Automated tests for creating a Planned Round in the TrackMan mobile app using Java, Appium, and TestNG.

# TrackMan Mobile App Test

## Overview
TrackManMobileAppTest is a mobile test automation framework designed to verify the functionality of creating a planned round in the TrackMan Mobile App. This project follows the **Page Object Model (POM)** to enhance maintainability and scalability of test scripts.

## Project Structure
```
TrackManMobileAppTest
│── main
│   ├── java
│   │   ├── org.trackman
│   │   │   ├── base
│   │   │   │   ├── DriverManager.java
│   │   │   ├── common
│   │   │   │   ├── Constants.java
│   │   │   ├── pages
│   │   │   │   ├── LandingPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── MainPage.java
│   │   │   │   ├── MyPlannedRoundPage.java
│   │   │   │   ├── UserDetailsPage.java
│   │   │   │   ├── VirtualGolfRoundPage.java
│   │   │   ├── utils
│   │   │   │   ├── ConfigReader.java
│   ├── resources
│   │   ├── config
│   │   │   ├── properties
│   │   │   ├── log4j2.xml
│── test
│   ├── java
│   │   ├── org.trackman
│   │   │   ├── base
│   │   │   │   ├── BaseClass.java
│   │   │   │   ├── BaseTest.java
│   │   │   ├── tests
│   │   │   │   ├── PlannedRoundCreationTest.java
│── target (build artifacts)
```

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
1. Java JDK 11+
2. Maven
3. Appium Server
4. Real Android Device ( Tested this 
5. TrackMan Mobile App installed

### Installation Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/TrackManMobileAppTest.git
   ```
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
* This APP tested in Android Real Device & Sucessfully Passed the All the steps 
  Android Device Name -  Vivo
  Version - Android 12

  

