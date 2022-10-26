import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest{

    @Test
    public void firstTask(){
        final String INPUT_DUCKDUCKGO = "search_form_input_homepage";
        final String FIRST_LINK_TEXT = "//*[@id='r1-0']//h2";
        headlessMode();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id(INPUT_DUCKDUCKGO)).sendKeys("ОТУС");
        driver.findElement(By.id(INPUT_DUCKDUCKGO)).submit();
        String text = driver.findElement(By.xpath(FIRST_LINK_TEXT)).getText();
        String text2 = driver.findElement(By.cssSelector("#r1-0>div>h2")).getText();
        logger.info("Text in first link by xpath - {}", text);
        logger.info("Text in second link by CSS - {}", text2);
        Assert.assertEquals(text, "Онлайн-курсы для профессионалов, дистанционное обучение");
        logger.info("Test done");
    }

    @Test
    public void secondTask(){
        final String PICTURE = "(//div[contains(@class, 'content-overlay')])[1]";
        final String OVERLAY = "//div[contains(@class, 'pp_overlay')]";
        kioskMode();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.xpath(PICTURE)).click();
        logger.info("picture should be big");
        Assert.assertTrue(driver.findElement(By.xpath(OVERLAY)).isDisplayed());
        logger.info("Test done");
    }

    @Test
    public void thirdTask(){
        final String BUTTON_ENTER = "//button[contains(@class, 'header2__auth')]";
        final String EMAIL_INPUT = "(//input[contains(@class, 'js-email-input')])[1]";
        final String PASSWORD_INPUT = "//input[contains(@class, 'new-input_password')]";
        setUpDefault();
        driver.manage().window().maximize();
        driver.get("https://otus.ru");
        driver.findElement(By.xpath(BUTTON_ENTER)).click();
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys("henij26062@ekbasia.com");
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys("1234567Qq@");
        driver.findElement(By.xpath(PASSWORD_INPUT)).submit();
        logger.info(driver.manage().getCookies());
    }
}
