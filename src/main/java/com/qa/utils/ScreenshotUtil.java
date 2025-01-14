package com.qa.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    // Method to capture screenshot and return its path
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Format the screenshot name with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            String filePath = "test-output/screenshots/" + fileName;

            // Copy the screenshot to the destination
            Path destinationPath = new File(filePath).toPath();
            Files.copy(srcFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            // Return the file path
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
