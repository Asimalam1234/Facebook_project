package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.Home;
import com.qa.pages.Login;
import com.qa.pages.Signup;

public class PageFactoryManager {

	
	
	 private WebDriver driver;

	    public PageFactoryManager(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Lazy Initialization of Page Objects
	    public Login getLoginPage() {
	        return PageFactory.initElements(driver, Login.class);
	    }

	    public Home getHomePage() {
	        return PageFactory.initElements(driver, Home.class);
	    }

	    public Signup getProfilePage() {
	        return PageFactory.initElements(driver, Signup.class);
	    }
}
