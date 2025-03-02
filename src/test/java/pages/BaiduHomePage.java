package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Baidu homepage
 */
public class BaiduHomePage {
    private final WebDriver driver;

    // Element locators
    private final By searchBox = By.id("kw");
    private final By searchButton = By.id("su");

    public BaiduHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open Baidu homepage
     */
    public void openHomePage() {
        driver.get("https://www.baidu.com");
    }

    /**
     * Perform search operation
     * 
     * @param keyword Search term to input
     */
    public void performSearch(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }
}