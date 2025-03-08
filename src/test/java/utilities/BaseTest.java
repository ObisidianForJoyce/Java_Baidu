package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

/**
 * Base test class for driver setup and teardown
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Configure Edge driver
        WebDriverManager.edgedriver().setup();

        // Edge browser options
        EdgeOptions options = new EdgeOptions();
        // options.addArguments("--start-maximized");
        // options.addArguments("--remote-allow-origins=*");
        options.addArguments(
                "--headless=new",
                "--remote-debugging-port=9222",
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-extensions",
                "--disable-software-rasterizer",
                "--remote-allow-origins=*",
                "--ignore-certificate-errors");
        // EdgeDriverService service = new EdgeDriverService.Builder()
        // .withLogFile(new File("C:\\agent\\_work\\logs\\edgedriver.log")) // 日志保存路径
        // .withVerbose(true) // 启用详细日志
        // .build();
        // driver = new EdgeDriver(service, options);
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
