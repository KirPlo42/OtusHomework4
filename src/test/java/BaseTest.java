import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public Logger logger = LogManager.getLogger(FirstTest.class);
    public WebDriver driver;

    public void setUpDefault(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Driver alive");
    }

    @AfterEach
    public void setDown(){
        if (driver != null)
            driver.quit();
    }

    public void headlessMode(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        logger.info("Driver alive in headless mode");
    }

    public void kioskMode(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        logger.info("Driver alive in kiosk mode");
    }
}
