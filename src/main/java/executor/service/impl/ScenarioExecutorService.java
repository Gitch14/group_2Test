package executor.service.impl;

import executor.model.Scenario;
import executor.model.Step;

import executor.service.StepExecutionService;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenarioExecutorService implements executor.service.ExecutorService {

    private StepExecutionServiceClickCss stepExecutionServiceClickCss;
    private StepExecutionClickXpath stepExecutionClickXpath;
    private StepExecutionServiceSleep stepExecutionServiceSleep;

    @Autowired
    public ScenarioExecutorService(StepExecutionServiceClickCss stepExecutionServiceClickCss,
                                   StepExecutionClickXpath stepExecutionClickXpath,
                                   StepExecutionServiceSleep stepExecutionServiceSleep) {
        this.stepExecutionServiceClickCss = stepExecutionServiceClickCss;
        this.stepExecutionClickXpath = stepExecutionClickXpath;
        this.stepExecutionServiceSleep = stepExecutionServiceSleep;
    }

    public ScenarioExecutorService() {

    }

    public void execute(Scenario scenario, WebDriver webDriver) {
        webDriver.get(scenario.getSite());
        List<Step> steps = scenario.getSteps();
        for (Step step : steps) {
            String action = step.getAction();

            StepExecutionService service = null;
            if (action.equalsIgnoreCase("clickCss")) {
                service = stepExecutionServiceClickCss;
            } else if (action.equalsIgnoreCase("sleep")) {
                service = stepExecutionServiceSleep;
            } else if (action.equalsIgnoreCase("clickXpath")) {
                service = stepExecutionClickXpath;
            }

            if (service != null) {
                service.step(webDriver, step);
            }
        }
    }

}
