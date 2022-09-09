package executor.facade.impl;

import executor.facade.ExecutionService;
import executor.model.Scenario;
import executor.service.ScenarioSourceListener;
import executor.service.impl.ScenarioExecutorService;
import org.openqa.selenium.WebDriver;

import java.util.Queue;

public class ExecutionServiceFacade implements ExecutionService {
    @Override
    public void execute(WebDriver webDriver, ScenarioSourceListener scenarioSourceListener, ScenarioExecutorService scenarioExecutor) {

        Queue<Scenario> queueOfScenarios = scenarioSourceListener.execute();
        Scenario scenario = queueOfScenarios.poll();
        scenarioExecutor.execute(scenario, webDriver);
    }
}
