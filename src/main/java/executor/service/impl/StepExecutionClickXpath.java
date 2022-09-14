package executor.service.impl;

import executor.model.Step;
import executor.service.StepExecutionService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StepExecutionClickXpath implements StepExecutionService {
    private static volatile StepExecutionClickXpath INSTANCE;
    private static final String STEP_ACTION = "clickXpath";

    private StepExecutionClickXpath(){};

    public static StepExecutionClickXpath getInstance(){
        if(INSTANCE == null) {
            synchronized (StepExecutionClickXpath.class) {
                if(INSTANCE == null) {
                    INSTANCE = new StepExecutionClickXpath();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String getStepAction() {
        return STEP_ACTION;
    }

    @Override
    public void step(WebDriver webDriver, Step step) {
        if (webDriver == null || step == null) {
            return;
        }
        try {
            WebElement webElement = webDriver.findElement(By.xpath(step.getValue()));
            if (webElement.isEnabled()) {
                webElement.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
