package com.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.reflect.Method;

public class Base {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {
        // Initialize ExtentReports
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        // Initialize the WebDriver from DriverFactory
        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(ConfigReader.getProperty("app.url"));

        // Create a new test for each method
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        // Log test result in ExtentReport
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed: " + result.getThrowable());
            
            // Capture screenshot on failure
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.fail("Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }

        // Quit WebDriver after the test
        if (driver != null) {
            driver.quit();
        }

        // Write the results to the report
        extent.flush();
    }
}
