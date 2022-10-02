package executor.facade.impl;

import executor.facade.ExecutionService;
import executor.model.Scenario;
import executor.service.ExecutorService;
import executor.service.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class ExecutionServiceFacade implements ExecutionService {

    @Override
    public void execute(WebDriver webDriver, ScenarioSourceListener scenarioSourceListener, ExecutorService executorService) {
        Queue<Scenario> queueOfScenarios = scenarioSourceListener.execute();
        while (!queueOfScenarios.isEmpty()) {
            Scenario scenario = queueOfScenarios.poll();
            executorService.execute(scenario, webDriver);
        }
    }

}
