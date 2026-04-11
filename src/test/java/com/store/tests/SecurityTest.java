package com.store.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class SecurityTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Ecommerce App")
    @Feature("Security")
    @Story("Verify that the application is protected against SQL injection and script injection")
    @Description("Verify that the application is protected against SQL injection and script injection")
    public void verifyLoginWithSQLInjection(){

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Ecommerce App")
    @Feature("Security")
    @Story("Verify that the application is protected against SQL injection and script injection")
    @Description("Verify that the application is protected against SQL injection and script injection")
    public void verifyRegisterWithScriptInjection(){

    }
}
