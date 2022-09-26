package executor.service.impl;

import executor.model.Step;
import executor.service.StepExecutionService;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class StepExecutionServiceSleep implements StepExecutionService {
    private static volatile StepExecutionServiceSleep INSTANCE;

    private StepExecutionServiceSleep() {
    }

    public static StepExecutionServiceSleep getInstance() {
        if (INSTANCE == null) {
            synchronized (StepExecutionServiceSleep.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StepExecutionServiceSleep();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String getStepAction() {
        return "sleep";
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
