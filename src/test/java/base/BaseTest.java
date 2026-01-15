package base;

// komentar za commit
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"baseUrl", "headless"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String baseUrl, String headless) {

        ChromeOptions options = new ChromeOptions();
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
