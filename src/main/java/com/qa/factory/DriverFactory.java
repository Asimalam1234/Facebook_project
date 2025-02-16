package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    // Initialize WebDriver based on browser name
    public static WebDriver initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {  // ✅ Correct condition
        	WebDriverManager.chromedriver().driverVersion("131.0.6778.205").setup();

    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--incognito");
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {  // ✅ Fix condition
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {  // ✅ Fix condition
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
        	
        }
        else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        return driver;
    }
}
