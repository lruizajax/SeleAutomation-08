# SeleAutomation-07 - Web Automation Project with Selenium

A user interface (UI) test automation project for an ecommerce application, using **Selenium WebDriver**, **TestNG**, and **Allure Reports**.

---

## 📋 Table of Contents

1. [General Description](#general-description)
2. [Requirements](#requirements)
3. [Project Structure](#project-structure)
4. [Dependencies](#dependencies)
5. [Page Object Model (POM)](#page-object-model-pom)
6. [Utilities](#utilities)
7. [Tests](#tests)
8. [Listeners](#listeners)
9. [Configuration](#configuration)
10. [Test Execution](#test-execution)
11. [Reports](#reports)

---

## 📝 General Description

This project automates tests for a demonstration web store (DemoWebShop - Tricentis) that includes:

- ✅ Home page tests
- ✅ User registration tests
- ✅ Login tests
- ✅ Product tests
- ✅ Shopping cart tests
- ✅ Checkout tests
- ✅ Security tests

**Application URL**: https://demowebshop.tricentis.com

---

## 🛠️ Requirements

- **Java**: JDK 11 or higher
- **Maven**: 3.6.0 or higher
- **ChromeDriver**: Compatible with your installed Chrome version
- **Database (Optional)**: MySQL for database validations
  - Host: `localhost:3306`
  - Database: `ecommerce`
  - User: `@S3lEn1um#`
  - Password: `**********`

---

## 📁 Project Structure

```
SeleAutomation-07/
├── src/
│   ├── main/java/com/store/
│   │   └── (Currently empty - structure for future reusable code)
│   └── test/
│       ├── java/com/store/
│       │   ├── tests/           # Test classes
│       │   ├── pages/           # Page Object Model
│       │   ├── utils/           # Utilities and helpers
│       │   └── listeners/       # TestNG Listeners
│       └── resources/
│           └── users.csv        # Test data
├── allure-results/              # Allure reports (generated)
├── target/                      # Compiled artifacts
├── pom.xml                      # Maven configuration
├── testng.xml                   # TestNG configuration
└── README.md                    # This file
```

---

## 📦 Dependencies

### Main Dependencies

| Dependency | Version | Purpose |
|-----------|---------|---------|
| **Selenium WebDriver** | 4.41.0 | Web browser automation |
| **TestNG** | 7.12.0 | Testing framework |
| **Log4j (SLF4J)** | 2.25.3 | Logging |
| **Apache POI OOXML** | 5.5.1 | Excel file read/write |
| **MySQL Connector** | 9.3.0 | MySQL database connection |
| **Allure TestNG** | 2.33.0 | Visual reports |
| **AspectJ Weaver** | 1.9.21 | Runtime aspect support |
| **JavaFaker** | 1.0.2 | Fake data generation |

### Build Plugins

- **Maven Surefire**: 3.5.4 (test execution)

---

## 🏗️ Page Object Model (POM)

The project implements the **Page Object Model** pattern to keep automation clean and reusable.

### Class Hierarchy

```
BasePage (abstract class)
├── HomePage
├── LoginPage
└── RegisterPage
```

### 📄 BasePage
**Location**: `src/test/java/com/store/pages/BasePage.java`

Base class that encapsulates all common browser interactions.

**Main Methods**:
- `find(By element)` - Finds an element
- `click(By element)` - Clicks on an element
- `type(By element, String text)` - Types text in a field
- `submit(By element)` - Submits a form
- `text(By element)` - Gets text from an element
- `isDisplayedElement(By locator)` - Verifies if an element is visible

**Attributes**:
- `driver` - WebDriver instance
- `wait` - WebDriverWait with configured timeout

---

### 📄 HomePage
**Location**: `src/test/java/com/store/pages/HomePage.java`

Represents the ecommerce home page.

**Web Elements**:
- `imgLogo` - Main logo
- `inputSearch` - Search field
- `linkRegister` - Registration link
- `linkLogin` - Login link

**Methods**:
- `verifyLogoIsDisplayed()` - Verifies that the logo is visible
- `verifyLogoIsDisplayedWithScreenShot()` - Verifies logo and captures screenshot
- `verifyInputSearchIsDisplayed()` - Verifies search field
- `clickRegister()` - Navigates to registration
- `clickLogin()` - Navigates to login
- `verifyMenuOptions()` - Verifies all top menu categories

**Supported Menu Categories** (MenuCategory enum):
- Books
- Computers
- Electronics
- Apparel & Shoes
- Digital downloads
- Jewelry
- Gift Cards

---

### 📄 LoginPage
**Location**: `src/test/java/com/store/pages/LoginPage.java`

Represents the login page.

**Web Elements**:
- `inputEmail` - Email field
- `inputPassword` - Password field
- `buttonLogin` - Login button
- `divMessage` - Error message

**Methods**:
- `fillOutForm()` - Fills form with default valid credentials
- `fillOutFormWithDataProvider(String email, String password)` - Fills form with parameterized data
- `clickLogin()` - Clicks login button
- `getLoginErrorMessage()` - Gets error message if login fails

**Test Credentials**:
- Email: `4rohaserrr@gmail.com`
- Password: `SueprPass@#$@@`

---

### 📄 RegisterPage
**Location**: `src/test/java/com/store/pages/RegisterPage.java`

Represents the new user registration page.

**Web Elements**:
- `inputGender` - Gender selector (Male)
- `inputFname` - First name field
- `inputLname` - Last name field
- `inputEmail` - Email field
- `inputPassword` - Password field
- `inputConPassword` - Confirm password field
- `buttonRegister` - Register button
- `divMessage` - Result message
- `lblErrorEmail` - Email error label
- `lblErrorMismatchPassword` - Password mismatch error label

**Methods**:
- `fillOutFormWithFakeData()` - Fills form with random data (JavaFaker)
- `fillOutFormWithInvalidEmail()` - Fills with empty email
- `fillOutFormMisMatchPassword()` - Fills with non-matching passwords
- `clickRegister()` - Clicks register button
- `verifyMessage()` - Gets confirmation message
- `verifyErrorEmail()` - Gets email error
- `verifyErrorMismatchPassword()` - Gets password error

**Defined Error Messages**:
- `ERROR_MESSAGE_INVALID_EMAIL = "Email is required."`
- `ERROR_MESSAGE_MISMATCH_PASSWORD = "The password and confirmation password do not match."`

---

## 🔧 Utilities

### 📄 BaseTest
**Location**: `src/test/java/com/store/utils/BaseTest.java`

Base class for all tests that configures the driver and pages.

**Attributes**:
- `driver` - Selenium WebDriver
- `TIME_OUT = 10` - Wait time in seconds
- `URL = "https://demowebshop.tricentis.com"` - Base URL
- `homePage`, `registerPage`, `loginPage`, `dbValidation` - Instances of pages and validators

**Methods**:
- `setup()` - Executes before each test (@BeforeMethod)
  - Initializes ChromeDriver
  - Maximizes browser window
  - Sets timeouts
  - Navigates to base URL
  - Initializes all pages

- `tearDown()` - Executes after each test (@AfterMethod)
  - Deletes all cookies
  - Closes browser

---

### 📄 AllureUtils
**Location**: `src/test/java/com/store/utils/AllureUtils.java`

Utilities for generating visual reports in Allure.

**Methods**:
- `takeScreenshot(WebDriver driver, String name)` - Takes screenshot and attaches as PNG image
  - Returns: `byte[]` - Image in bytes
  - Annotation: `@Attachment(value = "{name}", type = "image/png")`

- `captureScreenshot(WebDriver driver, String name)` - Captures screenshot with Allure step
  - Annotation: `@Step("Capturando screenshot: {name}")`

- `attachText(String name, String message)` - Attaches text to report
  - Annotation: `@Attachment(value = "{name}", type = "text/plain")`

- `attachPageSource(WebDriver driver)` - Attaches page source code
  - Annotation: `@Attachment(value = "Page Source", type = "text/html")`

---

### 📄 CsvData
**Location**: `src/test/java/com/store/utils/CsvData.java`

Utility for reading data from CSV files.

**Methods**:
- `getDataFromCsv(String path)` - Reads data from CSV file
  - Parameter: path to CSV file
  - Returns: `Object[][]` - Two-dimensional array with data
  - Skips first line (headers)

**Expected CSV Format**:
```csv
username,password
user1@test.com,pass123
user2@test.com,pass456
```

---

### 📄 DataProviders
**Location**: `src/test/java/com/store/utils/DataProviders.java`

Provides data for parameterized tests.

**Methods**:
- `getUserCredentials()` - DataProvider that reads credentials from CSV file
  - Name: `"dpFromCsv"`
  - Path: `/src/test/resources/users.csv`
  - Returns: `Object[][]` - User/password pairs

**Usage in Tests**:
```java
@Test(dataProvider = "dpFromCsv", dataProviderClass = DataProviders.class)
public void testWithData(String username, String password) {
    // Test logic
}
```

---

### 📄 DBValidation
**Location**: `src/test/java/com/store/utils/DBValidation.java`

Validations against MySQL database.

**Configuration**:
- `URL_CONNECTION = "jdbc:mysql://localhost:3306/selenium"`
- `USER = "root"`
- `PASSWORD = "password"`

**Methods**:
- `getConnection()` - Gets database connection
  - Returns: `Connection` - Active connection
  - Throws: `SQLException`

- `getUserByEmail(String email)` - Searches user by email
  - Parameter: user email
  - Returns: `String` - User name or error message
  - Error handling: Returns descriptive messages

**SQL Query**:
```sql
SELECT * FROM customers WHERE email = ?
```

---

### 📄 MenuCategory (Enum)
**Location**: `src/test/java/com/store/utils/MenuCategory.java`

Enumeration of main menu categories.

**Values**:
- `BOOKS("Books")`
- `COMPUTERS("Computers")`
- `ELECTRONICS("Electronics")`
- `APPAREL_SHOES("Apparel & Shoes")`
- `DIGITAL_DOWNLOADS("Digital downloads")`
- `JEWELRY("Jewelry")`
- `GIFT_CARDS("Gift Cards")`

**Usage**:
```java
for (MenuCategory category : MenuCategory.values()) {
    String label = category.getLabel();
    // Use to search menu elements
}
```

---

### 📄 Retry
**Location**: `src/test/java/com/store/utils/Retry.java`

Implementation of automatic retries for failed tests.

**Implements**: `IRetryAnalyzer` from TestNG

**Configuration**:
- `MAX_RETRY = 2` - Maximum number of retries

**Methods**:
- `retry(ITestResult result)` - Determines if test should be retried
  - Returns: `true` if should retry, `false` otherwise

- `isLastAttempt()` - Checks if it's the last attempt
- `getCurrentAttempt()` - Gets current attempt number (1-indexed)
- `getMaxRetry()` - Gets maximum retries

**Behavior**:
- First execution: attempt 1
- If fails: attempt 2
- If fails again: attempt 3 (no more retries)

---

## 🧪 Tests

### Test Structure

All tests extend from `BaseTest`, which automatically provides:
- WebDriver instance
- Instances of all pages
- Automatic setup/teardown

### Allure Annotations Used

Each test includes annotations for better documentation in reports:
- `@Severity` - Test severity level
- `@Epic` - Main feature or epic
- `@Feature` - Specific feature
- `@Story` - User story
- `@Description` - Detailed description

---

### 📄 HomeTest
**Location**: `src/test/java/com/store/tests/HomeTest.java`

Tests for the home page.

**Tests**:

1. **verifyMainLogo()**
   - Severity: NORMAL
   - Verifies that the main logo is visible
   - Epic: Ecommerce App
   - Feature: Home Page

2. **verifyInputSearch()**
   - Severity: BLOCKER
   - Verifies that the search field is visible and available
   - Epic: Ecommerce App
   - Feature: Home Page

3. **verifyTopHeaderMenu()**
   - Severity: CRITICAL
   - Verifies that all top menu options are available
   - Epic: Ecommerce App
   - Feature: Home Page

4. **verifyLoginWithEvidence()**
   - Severity: MINOR
   - Verifies the logo and captures screenshot as evidence
   - Epic: Ecommerce App
   - Feature: Home Page

---

### 📄 LoginTest
**Location**: `src/test/java/com/store/tests/LoginTest.java`

Tests for the login module.

**Tests**:

1. **doLoginTestWithDataProvider(String username, String password)**
   - Severity: CRITICAL
   - DataProvider: `dpFromCsv` (from `users.csv`)
   - Performs login with multiple sets of credentials
   - Epic: Ecommerce App
   - Feature: Login
   - Flow:
     1. Clicks on login link
     2. Fills form with provider data
     3. Clicks login button
     4. Validation pending

---

### 📄 RegisterTest
**Location**: `src/test/java/com/store/tests/RegisterTest.java`

Tests for the registration module.

**Tests**:

1. **verifyUserCanRegisterSuccessfully()**
   - Severity: CRITICAL
   - Validates complete new user registration
   - Flow:
     1. Navigates to registration
     2. Fills form with random data (JavaFaker)
     3. Submits form
     4. Verifies message: "Your registration completed"
   - Assertion: `assertEquals(registerPage.verifyMessage(), "Your registration completed")`

2. **verifyUserCannotRegisterWithInvalidEmail()**
   - Severity: NORMAL
   - Validates that registration is not allowed with empty email
   - Flow:
     1. Attempts to register with empty email
     2. Verifies error message
   - Assertion: `assertEquals(registerPage.verifyErrorEmail(), "Email is required.")`

3. **verifyUserCannotRegisterWithMismatchPassword()**
   - Severity: NORMAL
   - Validates that non-matching passwords are not allowed
   - Flow:
     1. Attempts to register with different passwords
     2. Verifies error message
   - Assertion: `assertEquals(registerPage.verifyErrorMismatchPassword(), "The password and confirmation password do not match.")`

---

### 📄 ProductTest
**Location**: `src/test/java/com/store/tests/ProductTest.java`

Tests for the product page (under development).

**Tests**:

1. **verifyProductDetails()**
   - Severity: NORMAL
   - Validates that product details are displayed correctly
   - Status: Under development (empty)

---

### 📄 CartTest
**Location**: `src/test/java/com/store/tests/CartTest.java`

Tests for the shopping cart (under development).

**Tests**:

1. **verifyAddToCart()**
   - Severity: CRITICAL
   - Validates adding items to cart
   - Status: Under development

2. **verifyRemoveFromCart()**
   - Severity: BLOCKER
   - Validates removing items from cart
   - Status: Under development

3. **verifyCartTotalCalculation()**
   - Severity: NORMAL
   - Validates that cart total calculation is correct
   - Status: Under development

---

### 📄 CheckoutTest
**Location**: `src/test/java/com/store/tests/CheckoutTest.java`

Tests for the checkout process (under development).

**Tests**:

1. **verifyCheckoutFlow()**
   - Severity: CRITICAL
   - Validates complete checkout flow
   - Status: Under development

2. **verifyCheckoutWithMissingData()**
   - Severity: NORMAL
   - Validates behavior when attempting checkout without required data
   - Status: Under development

---

### 📄 SecurityTest
**Location**: `src/test/java/com/store/tests/SecurityTest.java`

Security tests (under development).

**Tests**:

1. **verifyLoginWithSQLInjection()**
   - Severity: NORMAL
   - Validates protection against SQL injection in login
   - Status: Under development

2. **verifyRegisterWithScriptInjection()**
   - Severity: NORMAL
   - Validates protection against script injection in registration
   - Status: Under development

---

## 👂 Listeners

### 📄 TestListener
**Location**: `src/test/java/com/store/listeners/TestListener.java`

TestNG listener that captures failures and provides debugging information.

**Implements**:
- `ITestListener` - Listens to test events
- `IAnnotationTransformer` - Transforms test annotations

**Methods**:

1. **transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)**
   - Executes before each test
   - Automatically applies `Retry` analyzer to all tests
   - Enables automatic retries in case of failure

2. **onTestFailure(ITestResult result)**
   - Executes when a test fails
   - Actions:
     - Gets the WebDriver from the test
     - Gets information from the retry analyzer
     - Attaches attempt information to Allure
     - Captures screenshot on each failure
     - If it's the last attempt:
       - Captures final screenshot
       - Attaches the page source code

**Attached Information**:
- Current attempt number
- Maximum number of retries
- Screenshot of state on each failure
- Page source code (on final failure)

---

## ⚙️ Configuration

### pom.xml

**Maven Configuration**:
```xml
<groupId>com.store</groupId>
<artifactId>SeleAutomation-07</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>jar</packaging>
```

**Surefire Plugin** (test execution):
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.5.4</version>
    <configuration>
        <argLine>
            -javaagent:"${user.home}/.m2/repository/org/aspectj/aspectjweaver/1.9.21/aspectjweaver-1.9.21.jar"
        </argLine>
    </configuration>
</plugin>
```

---

### testng.xml

**TestNG Configuration**:
```xml
<suite name="Ecommerce Suite" parallel="classes">
    <listeners>
        <listener class-name="com.store.listeners.TestListener"></listener>
    </listeners>
    
    <!-- Tests configured in parallel by class -->
    <!-- Thread count: 5 for each test suite -->
</suite>
```

**Test Suites**:
1. Home Page Test
2. Register Page Test
3. Login Page Test
4. Product Page Test
5. Cart Page Test
6. Checkout Page Test
7. Security Tests

**Features**:
- Parallel execution by class
- 5 threads per suite
- TestListener active
- Automatic retries enabled

---

### Test Data File (users.csv)
**Location**: `src/test/resources/users.csv`

CSV file with test credentials for LoginTest.

**Format**:
```csv
username,password
user1@example.com,password123
user2@example.com,password456
```

---

## 🚀 Test Execution

### Run All Tests

```bash
mvn clean test
```

### Run a Specific Test Suite

```bash
mvn clean test -Dtest=HomeTest
mvn clean test -Dtest=LoginTest
mvn clean test -Dtest=RegisterTest
```

### Run Using TestNG XML

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run with Automatic Retries

Retries are automatically configured (MAX_RETRY = 2). Any test that fails will be retried up to 2 additional times.

### Run in Parallel

Already configured in `testng.xml`:
```xml
<suite name="Ecommerce Suite" parallel="classes">
    <test name="..." thread-count="5">
```

### Run a Specific Test

```bash
mvn clean test -Dtest=HomeTest#verifyMainLogo
```

---

## 📊 Reports

### Generate Allure Report

After running tests:

```bash
mvn allure:report
```

### View Report

```bash
mvn allure:serve
```

This command automatically opens the report in your default browser.

### Report Structure

Generated reports include:

- **Screenshots**: Captured on each failure
- **Page Source**: Source code on final failure
- **Retry Info**: Retry attempt information
- **Steps**: All steps annotated with @Step
- **Attachments**: Text, screenshots, and source code

### Results Folder

```
allure-results/
├── *-container.json    # Test containers
├── *-result.json       # Individual test results
└── history.json        # Execution history
```

---

## 🔍 Example Detailed Execution

### HomeTest

1. **Setup**: Chrome driver is initialized
2. **verifyMainLogo()**: 
   - Logo visibility is verified
   - Screenshot is captured on failure
3. **tearDown**: Cookies are deleted and driver is closed

### RegisterTest

1. **Setup**: Chrome driver is initialized
2. **verifyUserCanRegisterSuccessfully()**:
   - Navigates to registration page
   - Form fields are filled with random data (JavaFaker)
   - Form is submitted
   - Success message is verified
3. **tearDown**: Cookies are deleted and driver is closed

### LoginTest

1. **Setup**: Chrome driver is initialized
2. **doLoginTestWithDataProvider()**:
   - Credentials are read from users.csv
   - For each set of credentials:
     - Navigates to login
     - Fills out form
     - Submits form
     - Screenshot is captured on failure
3. **tearDown**: Cookies are deleted and driver is closed

---

## 🛠️ Troubleshooting

### ChromeDriver Not Found

```bash
# Download ChromeDriver compatible with your Chrome version
# https://chromedriver.chromium.org/
# Place it in your PATH or specify path in BaseTest
```

### Database Connection Failed

```bash
# Verify MySQL is running
# Verify credentials in DBValidation.java
# Verify "selenium" database exists
```

### Slow Tests

- Increase timeouts if necessary
- Reduce `thread-count` value in testng.xml
- Check internet connection speed

### Flaky Tests (False Positives)

- Automatic retries (Retry) help mitigate unstable tests
- Review XPath/CSS selectors for better stability
- Use explicit waits instead of implicit waits when possible

---

## 📈 Future Improvements

- [ ] Complete ProductTest tests
- [ ] Complete CartTest tests
- [ ] Complete CheckoutTest tests
- [ ] Complete SecurityTest tests
- [ ] Add more database validations
- [ ] Implement Page Factory to optimize selectors
- [ ] Add CI/CD integration (Jenkins, GitHub Actions, etc.)
- [ ] Increase test data coverage (Excel, JSON, etc.)

---

## 👥 Contributing

To contribute to this project:

1. Fork the repository
2. Create a branch for your feature (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License.

---

## 🔗 Useful References

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Allure Documentation](https://docs.qameta.io/allure/)
- [DemoWebShop Tricentis](https://demowebshop.tricentis.com/)
- [JavaFaker](https://github.com/DiUS/java-faker)
- [Apache POI](https://poi.apache.org/)

---

**Last Update**: March 28, 2026
**Project Version**: 1.0-SNAPSHOT

