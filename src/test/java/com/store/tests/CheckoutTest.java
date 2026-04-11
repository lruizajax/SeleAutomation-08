package com.store.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CheckoutTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Ecommerce App")
    @Feature("Checkout")
    @Story("Verify that the checkout flow works correctly")
    @Description("Verify that the checkout flow works correctly")
    public void verifyCheckoutFlow(){

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Ecommerce App")
    @Feature("Checkout")
    @Story("Verify that the checkout flow works correctly with missing data")
    @Description("Verify that the checkout flow works correctly with missing data")
    public void verifyCheckoutWithMissingData(){

    }
}
