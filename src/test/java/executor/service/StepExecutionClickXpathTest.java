package executor.service;

import executor.model.Step;
import executor.service.impl.StepExecutionClickXpath;
import executor.service.StepExecutionService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class StepExecutionClickXpathTest {
    private StepExecutionService stepExecutionService;
    private Step step;
    private String value = "//li[@class='menu-categories__item ng-star-inserted']/a[contains(text(), 'Ноутбуки та комп’ютери')]";

    @Test
    void checkGetStepAction() {
        step = new Step("clickxpath", value);
        stepExecutionService = new StepExecutionClickXpath();
        assertEquals("Step action is wrong", stepExecutionService.getStepAction(), "clickxpath");
    }

    @Test
    public void checkStepClickXpath() throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        TimeUnit.SECONDS.sleep(5L);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");*/
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        StepExecutionClickXpath clickXpathTest = new StepExecutionClickXpath();
        step = new Step("clickxpath", value);
        clickXpathTest.step(driver, step);
        TimeUnit.SECONDS.sleep(5L);
        WebElement element = driver.findElement(By.xpath("//h1[@class='portal__heading ng-star-inserted']"));
        assertThat(element.isEnabled(), is(true));
        driver.close();
        driver.quit();
    }


}
