package executor.service.impl;

import executor.model.Step;
import executor.service.StepExecutionService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StepExecutionClickXpath implements StepExecutionService {

    @Override
    public String getStepAction() {
        return "clickxpath";
    }

    @Override
    public void step(WebDriver webDriver, Step step) {
        if (webDriver == null || step == null) {
            return;
        }
        try {
            WebElement webElement = webDriver.findElement(By.xpath(step.getValue()));
            if (webElement != null) {
                webElement.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
