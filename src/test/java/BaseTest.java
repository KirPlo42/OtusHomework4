import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {
    public Logger logger = LogManager.getLogger(FirstTest.class);
    public WebDriver driver;

    @BeforeTest
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }
    public void setImplicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public void setUpDefault(){
        driver = new ChromeDriver();
        setImplicitlyWait();
        logger.info("Driver alive");
    }

    @AfterTest(alwaysRun = true)
    public void setDown(){
        if (driver != null)
            driver.quit();
    }

    public void headlessMode(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless",
                "--window-size=1920,1080");
        driver = new ChromeDriver(options);
        setImplicitlyWait();
        logger.info("Driver alive in headless mode");
    }

    public void kioskMode(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        setImplicitlyWait();
        logger.info("Driver alive in kiosk mode");
    }
}