package executor.facade;

import executor.service.ExecutorService;
import executor.service.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

public interface ExecutionService {

    void execute(WebDriver webDriver, ScenarioSourceListener scenarioSourceListener, ExecutorService executorService);

}
