package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaiduHomePage;
import utilities.BaseTest;

/**
 * Test cases for Baidu search functionality
 * Test Changes in branch......
 */
public class SearchTest extends BaseTest {

    @Test
    public void testBasicSearchFunctionality() {
        BaiduHomePage homePage = new BaiduHomePage(driver);

        // Test steps
        homePage.openHomePage();
        homePage.performSearch("Selenium Automation");

        // Verification
        // String pageTitle = driver.getTitle();
        String pageURl = driver.getCurrentUrl();
        // System.out.println("page title is: " + pageTitle);
        System.out.println("page current URL is: " + pageURl);
        Assert.assertTrue(pageURl.contains("Selenium"),
                "Search result validation failed");
    }
}