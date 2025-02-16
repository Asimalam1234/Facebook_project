package com.qa.testscripts;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.factory.PageFactoryManager;
import com.qa.pages.Login;

import com.qa.utils.JsonReader;

public class LoginTest extends Base {
	@Test(dataProvider = "LoginData", dataProviderClass = JsonReader.class)

	public void verifyLogin(String username, String password) {
		// Initialize Page Factory
		PageFactoryManager pageFactory = new PageFactoryManager(driver);
		Login loginPage = pageFactory.getLoginPage();

		// Enter login credentials
		test.info("Entering username: " + username);
		loginPage.enterUsername(username);

		test.info("Entering password.");
		loginPage.enterPassword(password);

		test.info("Clicking login button.");
		loginPage.clickLogin();

		// Log success
		test.pass("Login verification passed.");
		Assert.assertTrue(loginPage.wrongCredentialsErrorMessage(),"Wrong Credentials");
		loginPage.highlightElement();
	}

}
