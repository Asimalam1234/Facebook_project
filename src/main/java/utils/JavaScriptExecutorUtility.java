package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorUtility {

    private WebDriver driver;
    private JavascriptExecutor js;

    // Constructor to initialize WebDriver
    public JavaScriptExecutorUtility(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Method to execute simple JavaScript
    public Object executeScript(String script) {
        return js.executeScript(script);
    }

    // Method to scroll the page by a given amount
    public void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    // Method to scroll to a specific element
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to highlight an element with a red border
    public void highlightElement(By highlitElement) {
        js.executeScript("arguments[0].style.border='3px solid red';", highlitElement);
    }

    // Method to trigger a JavaScript alert
    public void triggerAlert(String message) {
        js.executeScript("alert('" + message + "');");
    }

    // Method to get the page URL
    public String getPageURL() {
        return (String) js.executeScript("return window.location.href;");
    }

    // Method to set an input field value using JavaScript
    public void setInputValue(WebElement element, String value) {
        js.executeScript("arguments[0].value = '" + value + "';", element);
    }

    // Method to remove an element from the DOM
    public void removeElement(WebElement element) {
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", element);
    }

    // Method to change the background color of an element
    public void changeBackgroundColor(WebElement element, String color) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "';", element);
    }

    // Method to scroll to the bottom of the page
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Method to scroll to the top of the page
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Method to get the inner text of an element
    public String getElementText(WebElement element) {
        return (String) js.executeScript("return arguments[0].innerText;", element);
    }

    // Method to execute asynchronous JavaScript
    public void executeAsyncScriptExample() {
        String script = "var callback = arguments[arguments.length - 1]; " +
                        "setTimeout(function(){ callback('Hello from Async!'); }, 2000);";
        String result = (String) js.executeAsyncScript(script);
        System.out.println(result);
    }
}
