package org.example.test;

import org.example.Utilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TEST_001_Launch_Amazon_India_Website {

    public static String screenshotsPath = "src/test/resources/screenshots/TEST_001_Amazon_India_Website/";

    @BeforeTest
    public static void setup() {
        Utilities.chromeBrowserSetup();
    }

    @Test
    public static void test001_launchAmazonIndiaWebsite() {
        Utilities.launchURL("https://www.amazon.in/");
        Utilities.waitForPageLoad();
        Utilities.takeScreenshot(screenshotsPath);
    }

    @AfterTest
    public static void tearDown() {
        Utilities.closeBrowser();
    }
}
