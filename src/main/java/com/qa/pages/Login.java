package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.JavaScriptExecutorUtility;

public class Login {

public WebDriver driver;
private JavaScriptExecutorUtility jsUtility;
    private By userEmail = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By errorMessage=By.xpath("//p[text()='Invalid credentials']");
    private By highlitElement =By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]");
    public Login(WebDriver driver) {
        this.driver = driver;
        this.jsUtility = new JavaScriptExecutorUtility(driver);
    }

    public void enterUsername(String user) {
        driver.findElement(userEmail).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    public boolean wrongCredentialsErrorMessage() {
        return driver.findElement(errorMessage).isDisplayed();
    }
    public void highlightElement() {
        jsUtility.highlightElement(highlitElement);
    }
}
