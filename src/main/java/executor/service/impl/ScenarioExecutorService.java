package executor.service.impl;

import executor.model.Scenario;
import executor.model.Step;

import executor.service.StepExecutionService;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class ScenarioExecutorService implements executor.service.ExecutorService {
    public void execute(Scenario scenario, WebDriver webDriver) {
        webDriver.get(scenario.getSite());
        List<Step> steps = scenario.getSteps();
        for (Step step : steps) {
            String action = step.getAction();

            StepExecutionService service = null;
            if (action.equalsIgnoreCase("clickCss")) {
                service = StepExecutionServiceClickCss.getInstance();
            } else if (action.equalsIgnoreCase("sleep")) {
                service = StepExecutionServiceSleep.getInstance();
            } else if (action.equalsIgnoreCase("clickXpath")) {
                service = StepExecutionClickXpath.getInstance();
            }

            service.step(webDriver, step);
        }
    }
}
