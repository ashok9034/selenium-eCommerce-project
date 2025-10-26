package org.example.test;

import org.example.Utilities;
import org.testng.annotations.Test;

public class TEST_001_Launch_Amazon_India_Website {

    @Test
    public static void test001_launchAmazonIndiaWebsite() {
        Utilities.chromeBrowserSetup();
        Utilities.launchURL("https://www.amazon.in/");
        Utilities.closeBrowser();
    }
}
