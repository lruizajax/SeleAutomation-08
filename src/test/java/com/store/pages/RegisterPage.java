package com.store.pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    protected WebDriver driver;
    protected Faker faker;

    public static String ERROR_MESSAGE_INVALID_EMAIL = "Email is required.";
    public static String ERROR_MESSAGE_MISMATCH_PASSWORD = "The password and confirmation password do not match.";
    /**
     * Web Elements
     */

    By inputGender = By.cssSelector("input#gender-male");
    By inputFname = By.id("FirstName");
    By inputLname = By.id("LastName");
    By inputEmail = By.id("Email");
    By inputPassword = By.cssSelector("#Password");
    By inputConPassword = By.id("ConfirmPassword");
    By buttonRegister = By.id("register-button");
    By divMessage = By.className("result");
    By lblErrorEmail = By.xpath("//span[@data-valmsg-for='Email']/span");
    By lblErrorMismatchPassword = By.xpath("//span[@data-valmsg-for='ConfirmPassword']/span");

    /**
     * Constructor
     **/

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        faker = new Faker();
    }

    /**
     * methods
     *
     **/

    @Step("Fill out the form with fake data - happy path")
    public void fillOutFormWithFakeData() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(10, 12, true, true, true);
        click(inputGender);
        type(inputFname, faker.address().firstName());
        type(inputLname, faker.address().lastName());
        type(inputEmail, email);
        type(inputPassword, password);
        type(inputConPassword, password);
        System.out.println("Email is: " + email + " And Password: " + password);
    }

    @Step("Fill out the form with invalid email")
    public void fillOutFormWithInvalidEmail() {
        String email = "";
        String password = faker.internet().password(10, 12, true, true, true);
        click(inputGender);
        type(inputFname, faker.address().firstName());
        type(inputLname, faker.address().lastName());
        type(inputEmail, email);
        type(inputPassword, password);
        type(inputConPassword, password);
        System.out.println("Email is: " + email + " And Password: " + password);
    }

    @Step("Fill out the form with mismatch password")
    public void fillOutFormMisMatchPassword() {
        String email = faker.internet().emailAddress();
        click(inputGender);
        type(inputFname, faker.address().firstName());
        type(inputLname, faker.address().lastName());
        type(inputEmail, email);
        type(inputPassword, faker.internet().password(10, 12, true, true, true));
        type(inputConPassword, faker.internet().password(10, 12, true, true, true));
        System.out.println("Email is: " + email);
    }

    @Step("Click on register button")
    public void clickRegister() {
        click(buttonRegister);
    }


    @Step("Verify message after register")
    public String verifyMessage() {
        return text(divMessage);
    }

    @Step("Verify error message for invalid email")
    public String verifyErrorEmail() {
        return text(lblErrorEmail);
    }

    @Step("Verify error message for mismatch password")
    public String verifyErrorMismatchPassword() {
        return text(lblErrorMismatchPassword);
    }
}
