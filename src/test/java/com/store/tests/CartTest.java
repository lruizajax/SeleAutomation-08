package com.store.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Ecommerce App")
    @Feature("Cart")
    @Story("Verify that adding items to the cart works correctly")
    @Description("Verify that adding items to the cart works correctly")
    public void verifyAddToCart(){

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Ecommerce App")
    @Feature("Cart")
    @Story("Verify that removing items from the cart works correctly")
    @Description("Verify that removing items from the cart works correctly")
    public void verifyRemoveFromCart(){
        //implementar
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Ecommerce App")
    @Feature("Cart")
    @Story("Verify that the cart total calculation is correct")
    @Description("Verify that the cart total calculation is correct")
    public void verifyCartTotalCalculation(){

    }
}
