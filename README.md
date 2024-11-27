# Selenium Automation Framework

This is a Selenium-based automation framework using **Java**, **Selenium**, **TestNG**, and **Maven**. The framework supports thread safety, test data from Excel, property file configurations, and generates detailed reports using Allure.

## Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **AssertJ**
- **Page Object Model (POM)**
- **Thread Local Support** (Thread Safety)
- **Allure Reporting**
- **Excel Sheet for Test Data (Data Provider)**
- **Properties File for Configuration (Username, Password)**

## Features

- **TestNG**: Utilizes TestNG for managing tests with annotations like `@Test`, `@BeforeMethod`, and `@AfterMethod`.
- **Page Object Model (POM)**: Follows the POM design pattern for better maintainability and readability.
- **Thread Safety**: Implements Thread Local for ensuring that each test case has its own WebDriver instance.
- **Allure Reporting**: Generates rich test reports using Allure.
- **Excel Data Provider**: Uses Excel files for feeding test data into tests dynamically.
- **Properties File**: Reads sensitive data such as username and password from a `.properties` file for better security and flexibility.
  
