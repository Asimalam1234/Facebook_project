package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Kinectro\\Desktop\\Facebook_Automation\\src\\main\\resources\\config\\config.properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
