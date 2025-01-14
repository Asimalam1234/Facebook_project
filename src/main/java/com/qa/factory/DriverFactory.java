package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

    // Initialize WebDriver based on browser name
    public static WebDriver initDriver(String browser) {
        if (browser.equalsIgnoreCase(ConfigReader.getProperty("browser"))) {
        	WebDriverManager.chromedriver().driverVersion("131.0.6778.205").setup();

    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--incognito");
    		driver = new ChromeDriver(options);
        	
        } else if (browser.equalsIgnoreCase(ConfigReader.getProperty("browser"))) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase(ConfigReader.getProperty("browser"))) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        return driver;
    }
	
	
}
