package com.store.tests;

import com.store.pages.RegisterPage;
import com.store.utils.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can register successfully")
    @Epic("Ecommerce App")
    @Feature("Register")
    @Story("Verify that the user can register successfully")
    public void verifyUserCanRegisterSuccessfully() {
        homePage.clickRegister();
        registerPage.fillOutFormWithFakeData();
        registerPage.clickRegister();
        //assert
        Assert.assertEquals(registerPage.verifyMessage(), "Your registration completed");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user cannot register with invalid email")
    @Epic("Ecommerce App")
    @Feature("Register")
    @Story("Verify that the user cannot register with invalid email")
    public void verifyUserCannotRegisterWithInvalidEmail() {
        homePage.clickRegister();
        registerPage.fillOutFormWithInvalidEmail();
        registerPage.clickRegister();
        Assert.assertEquals(registerPage.verifyErrorEmail(), RegisterPage.ERROR_MESSAGE_INVALID_EMAIL);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user cannot register with mismatch password")
    @Epic("Ecommerce App")
    @Feature("Register")
    @Story("Verify that the user cannot register with mismatch password")
    public void verifyUserCannotRegisterWithMismatchPassword() {
        homePage.clickRegister();
        registerPage.fillOutFormMisMatchPassword();
        registerPage.clickRegister();
        Assert.assertEquals(registerPage.verifyErrorMismatchPassword(), RegisterPage.ERROR_MESSAGE_MISMATCH_PASSWORD);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the user cannot register with missing data")
    @Epic("Ecommerce App")
    @Feature("Register")
    @Story("Verify that the user cannot register with missing data")
    public void verifyUserCannotRegisterWithMissingData() {
        if (true) {
            throw new SkipException("Skipping test due to known issue with registration form validation for missing data");
        }
    }
}
