package executor.service;

import executor.model.Step;
import executor.service.impl.StepExecutionServiceClickCss;
import executor.service.impl.WebDriverChromeService;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.*;

public class StepExecutionServiceClickCssTest {
     @Test
    public void ClickCssTest() {
         WebDriver webDriver = mock(WebDriver.class);
        StepExecutionServiceClickCss stepExecutionClickCss = StepExecutionServiceClickCss.getInstance();
        stepExecutionClickCss.step(webDriver, new Step("clickCss",
                "body > ul > li:nth-child(1) > a"));
        verify(webDriver, times(1)).
                findElement(By.cssSelector("body > ul > li:nth-child(1) > a"));
    }
}
