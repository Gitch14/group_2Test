package executor.facade.impl;

import executor.facade.ExecutionService;
import executor.service.ExecutorService;
import executor.service.ScenarioSourceListener;
import executor.service.impl.ScenarioExecutorService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.util.ObjectMapperUtil;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.*;

public class ExecutionServiceFacadeTest {

    @Test
    public void executeTest() {
        WebDriver webDriver = mock(WebDriver.class);
        ScenarioSourceListener scenarioSourceListener = new ScenarioSourceListenerService(new ObjectMapperUtil());
        ExecutorService executorService = mock(ScenarioExecutorService.class);
        ExecutionService executionService = mock(ExecutionServiceFacade.class);
        executionService.execute(webDriver, scenarioSourceListener, executorService);
        verify(executionService, times(1)).execute(webDriver, scenarioSourceListener, executorService);
    }
}
