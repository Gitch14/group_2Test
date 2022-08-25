package executor.service.impl;

import executor.model.Scenario;
import executor.model.Step;

import executor.service.StepExecutionService;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ScenarioExecutorService implements executor.service.ExecutorService
{
    public void execute(Scenario scenario, WebDriver webDriver)
    {
        List<Step> steps = scenario.getSteps();
        for (Step step : steps)
        {
            String action = step.getAction();
            StepExecutionService service = null;
            switch (action)
            {
                case "clickCSS":
                    service = StepExecutionServiceClickCss.getInstance();
                    break;
                case "sleep":
                    service = StepExecutionServiceSleep.getInstance();
                    break;
                case "clickXpath":
                    // todo
                    // service = StepExecutionClickXpath.getInstance();
                    break;
                default:
                    service.step(webDriver, step);
            }
        }
    }
}
