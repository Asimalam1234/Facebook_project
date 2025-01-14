package com.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.Base;
import com.qa.factory.PageFactoryManager;
import com.qa.pages.Login;
import com.qa.utils.ConfigReader;

public class LoginTest extends Base {

    @Test
    public void verifyLogin() {
        // Create an instance of PageFactoryManager and the Login page
        PageFactoryManager pageFactory = new PageFactoryManager(driver);
        Login loginPage = pageFactory.getLoginPage();

        // Log the action of entering username
        test.info("Entering username: " + ConfigReader.getProperty("fb.username"));
        loginPage.enterUsername(ConfigReader.getProperty("fb.username"));

        // Log the action of entering password
        test.info("Entering password for the user.");
        loginPage.enterPassword(ConfigReader.getProperty("fb.password"));

        // Log the action of clicking login
        test.info("Clicking on login button.");
        loginPage.clickLogin();

        // Assertion to verify login success
        test.info("Verifying page title after login.");
        Assert.assertEquals(driver.getTitle(), "Facebook");
        
        // Log the test result
        test.pass("Login verification passed and title matches.");
    }
}
