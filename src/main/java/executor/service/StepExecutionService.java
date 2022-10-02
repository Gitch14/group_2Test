package executor.service;

import executor.model.Step;
import org.openqa.selenium.WebDriver;

public interface StepExecutionService {
    String getStepAction();
    void step(WebDriver webDriver, Step step);
}
