package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.logging.Logger;

public class Utilities {

    public static WebDriver driver;
    public static WebElement element;
    public static WebDriverWait wait;
    public static Logger logger = Logger.getLogger(Utilities.class.getName());
    public static Select select;
    public static Actions actions;

    // ================= Configuring launch and close browser ================= //
    // Initialize the Chrome browser
    public static void chromeBrowserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Chrome browser launched successfully.");
    }

    // Close the browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
    }

    // Launch a URL
    public static void launchURL(String url) {
        driver.navigate().to(url);
        threadSleep(5000);
    }

    // ================= Wait Utilities ================= //
    // Thread sleep utility
    public static void threadSleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Wait for an element to be visible
    public static void waitElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be clickable
    public static void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for the page to load completely
    public static void waitForPageLoad() {
        wait.until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState"), "complete"));
    }

    // ================ Clicking on Web Elements ================= //
    // Click on an element
    public static void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        logger.info("Clicked on element: " + locator.toString());
    }

    // Double-click on an element
    public static void doubleClickElement(By locator) {
        element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        actions.doubleClick(element).perform();
        logger.info("Double clicked on element: " + locator.toString());
    }

    // Right-click on an element
    public static void rightClickElement(By locator) {
        element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        actions.contextClick(element).perform();
        logger.info("Right clicked on element: " + locator.toString());
    }

    // Hover over an element
    public static void hoverOverElement(By locator) {
        element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        actions.moveToElement(element).perform();
        logger.info("Hovered over element: " + locator.toString());
    }

    // ================= Working with Web Elements ================= //
    // Send keys to an element
    public static void sendKeysToElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        logger.info("Sent keys to element: " + locator.toString() + " Text: " + text);
    }

    // Clear text from an element
    public static void clearElementText(By locator) {
        driver.findElement(locator).clear();
        logger.info("Cleared text from element: " + locator.toString());
    }

    // Clear and send keys to an element
    public static void clearAndSendKeysToElement(By locator, String text) {
        element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        logger.info("Cleared and sent keys to element: " + locator.toString() + " Text: " + text);
    }

    // Get text from an element
    public static String getElementText(By locator) {
        String text = driver.findElement(locator).getText();
        logger.info("Retrieved text from element: " + locator.toString() + " Text: " + text);
        return text;
    }

    // Select an option from dropdown by visible text
    public static void selectByVisibleText(By locator, String visibleText) {
        select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
        logger.info("Selected option by visible text: " + visibleText + " from element: " + locator.toString());
    }

    // Select an option from dropdown by value
    public static void selectByValue(By locator, String value) {
        select = new Select(driver.findElement(locator));
        select.selectByValue(value);
        logger.info("Selected option by value: " + value + " from element: " + locator.toString());
    }

    // Select an option from dropdown by index
    public static void selectByIndex(By locator, int index) {
        select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
        logger.info("Selected option by index: " + index + " from element: " + locator.toString());
    }

    // ==================== GET METHODS ====================
    // Get text of an element
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Get attribute value of an element
    public String getAttribute(By locator, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
    }

    // Get the title of the current page
    public String getTitle() {
        return driver.getTitle();
    }

    // Get the current URL of the page
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Get the page source of the current page
    public String getPageSource() {
        return driver.getPageSource();
    }

}
