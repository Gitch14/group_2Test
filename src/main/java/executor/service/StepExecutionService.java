package executor.service;

import executor.model.Step;
import org.openqa.selenium.WebDriver;

public interface StepExecutionService {
    public String getStepAction();
    public void step(WebDriver webDriver, Step step);
}
