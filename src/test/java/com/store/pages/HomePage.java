package com.store.pages;

import com.store.utils.AllureUtils;
import com.store.utils.MenuCategory;
import io.qameta.allure.Step;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    WebDriver driver;
    /***
     *
     * web elements
     */

    By imgLogo = By.className("header-logo");
    By inputSearch = By.id("small-searchterms");
    By linkRegister = By.linkText("Register");
    By linkLogin = By.linkText("Log in");

    /**
     * Constructor
     *
     *
     */
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Methods
     *
     *
     */
    @Step("Verify logo is displayed")
    public boolean verifyLogoIsDisplayed() {
        return find(imgLogo).isDisplayed();
    }

    @Step("Verify logo is displayed with ScreenShot")
    public void verifyLogoIsDisplayedWithScreenShot() {
        boolean logo = find(imgLogo).isDisplayed();
        AllureUtils.takeScreenshot(driver, "HomePage - Logo Displayed");
    }

    @Step("Verify input search is displayed")
    public boolean verifyInputSearchIsDisplayed() {
        return find(inputSearch).isEnabled();
    }

    @Step("Click on register link")
    public void clickRegister() {
        click(linkRegister);
    }

    @Step("Click on login link")
    public void clickLogin() {
        click(linkLogin);
    }

    @Step("Verify menu options")
    public void verifyMenuOptions() {
        for (MenuCategory category : MenuCategory.values()) {

            //locate option menu
            String menuName = "//ul[@class='top-menu']//a[contains(text(),'" + category.getLabel() + "')]";
            WebElement menu = find(By.xpath(menuName));

            //clic menu
            menu.click();

            //assert menu
            String pageHeader = find(By.tagName("h1")).getText();

            System.out.println("title is: " + pageHeader);
        }
    }
}
