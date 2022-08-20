package executor.service.impl;

import executor.model.Step;
import executor.service.StepExecutionService;
import executor.service.WebDriverInitializerService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepExecutionServiceClickCss implements StepExecutionService {
    @Override
    public String getStepAction() {
        return "Click";
    }

    @Override
    public void step(WebDriver webDriver, Step step) {
        WebDriverInitializerService browser = new WebDriverChromeService();
        WebDriver chrome = browser.create();

        chrome.get("http://info.cern.ch/");

        chrome.findElement(By.cssSelector(step.getValue())).click();
    }
}
