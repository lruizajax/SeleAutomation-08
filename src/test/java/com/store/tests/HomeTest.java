package com.store.tests;

import com.store.utils.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Ecommerce App")
    @Feature("Home Page")
    @Story("Verify that the main logo is displayed on the home page")
    @Description("Verify that the main logo is displayed on the home page")
    public void verifyMainLogo() {
        Assert.assertFalse(homePage.verifyLogoIsDisplayed());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Ecommerce App")
    @Feature("Home Page")
    @Story("Verify that the search input field is displayed on the home page")
    @Description("Verify that the search input field is displayed on the home page")
    public void verifyInputSearch() {
        homePage.verifyInputSearchIsDisplayed();
        //assertion
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Ecommerce App")
    @Feature("Home Page")
    @Story("Verify that the top header menu options are displayed on the home page")
    @Description("Verify that the top header menu options are displayed on the home page")
    public void verifyTopHeaderMenu() {
        homePage.verifyMenuOptions();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Epic("Ecommerce App")
    @Feature("Home Page")
    @Story("Verify that the register link is displayed on the home page")
    @Description("Verify that the register link is displayed on the home page")
    public void verifyLoginWithEvidence() {
        homePage.verifyLogoIsDisplayedWithScreenShot();
        /// simepre se hace en el test
    }
}


