package executor.service;

import executor.service.impl.WebDriverChromeService;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepExecutionServiceClickCssTest {

   @BeforeClass
    public static void setup() {

       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
   }

    @Test
    public void ClickCssTest(){


        WebDriverInitializerService browser = new WebDriverChromeService();
        WebDriver chrome = browser.create();

        chrome.get("http://info.cern.ch/");

        chrome.findElement(By.cssSelector("body > ul > li:nth-child(3) > a")).click();
        chrome.close();

    }
}
