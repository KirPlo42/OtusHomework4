import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class FirstTest extends BaseTest{

    @Test
    public void firstTask(){
        headlessMode();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id(Elements.INPUT_DUCKDUCKGO)).sendKeys("ОТУС");
        driver.findElement(By.id(Elements.INPUT_DUCKDUCKGO)).submit();
        String text = driver.findElement(By.xpath(Elements.FIRST_LINK_TEXT)).getText();
        logger.info(text + " text in first link");
        Assert.assertEquals(text, "Онлайн-курсы для профессионалов, дистанционное обучение");
        logger.info("Test done");
    }

    @Test
    public void secondTask(){
        kioskMode();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.xpath(Elements.PICTURE)).click();
        logger.info("picture should be big");
        Assert.assertTrue(driver.findElement(By.xpath(Elements.OVERLAY)).isDisplayed());
        logger.info("Test done");
    }

    @Test
    public void thirdTask() throws InterruptedException {
        setUpDefault();
        driver.manage().window().maximize();
        driver.get("https://otus.ru");
        driver.findElement(By.xpath(Elements.BUTTON_ENTER)).click();
        sleep(2000);
        driver.findElement(By.xpath(Elements.EMAIL_INPUT)).sendKeys("henij26062@ekbasia.com");
        driver.findElement(By.xpath(Elements.PASSWORD_INPUT)).sendKeys("1234567Qq@");
        driver.findElement(By.xpath(Elements.PASSWORD_INPUT)).submit();
        logger.info(driver.manage().getCookies());
    }
}
