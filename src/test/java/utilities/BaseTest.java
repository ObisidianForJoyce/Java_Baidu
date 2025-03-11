package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.SessionNotCreatedException;
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
        // System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
        // Edge browser options
        EdgeOptions options = new EdgeOptions();
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\msedge.exe");
        // options.addArguments("--start-maximized");
        // options.addArguments("--remote-allow-origins=*");
        options.addArguments(
                // "--headless", // 使用传统无头模式
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*");
        // "--remote-debugging-port");
        EdgeDriverService service = new EdgeDriverService.Builder()
                .withLogFile(new File("target/edgedriver.log")) // 使用相对路径
                .withVerbose(true)
                .build();
        try {
            driver = new EdgeDriver(service, options);
        } catch (SessionNotCreatedException e) {
            System.out.println("Edge启动失败，详细错误信息：");
            e.printStackTrace();
            throw e; // 继续抛出异常以中断测试
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
