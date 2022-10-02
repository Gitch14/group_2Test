package executor.service.impl;

import executor.model.Step;
import executor.service.StepExecutionService;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StepExecutionServiceSleep implements StepExecutionService {

    private static final String STEP_ACTION = "sleep";

    public StepExecutionServiceSleep() {

    }

    @Override
    public String getStepAction() {
        return STEP_ACTION;
    }

    @Override
    public void step(WebDriver webDriver, Step step) {
        if (step == null) {
            return;
        }
        try {
            TimeUnit.SECONDS.sleep(Long.parseLong(step.getValue()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
