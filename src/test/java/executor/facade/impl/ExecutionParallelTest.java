package executor.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.Scenario;
import executor.service.impl.ProxySourcesClientService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.util.ObjectMapperUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


public class ExecutionParallelTest {
    @Test
    public void parallelTest() {
/*
        Worker worker = new Worker();
        ParallelFlowExecuteService parallelFlowExecuteService = new ParallelFlowExecuteService();
        parallelFlowExecuteService.parallelExecute(worker);


 */
        ProxySourcesClientService proxySourcesClientService = new ProxySourcesClientService(new ObjectMapper());
        ScenarioSourceListenerService scenarioSourceListenerService = new ScenarioSourceListenerService(new ObjectMapperUtil());
        Queue<Scenario> scenarios = scenarioSourceListenerService.execute();


        ParallelFlowExecuteService parallelFlowExecuteService = new ParallelFlowExecuteService();
        parallelFlowExecuteService.parallelExecute(new Task(scenarioSourceListenerService,proxySourcesClientService,scenarios));
        ParallelFlowExecuteService parallel = mock(ParallelFlowExecuteService.class);
        parallel.parallelExecute(new Task(scenarioSourceListenerService,proxySourcesClientService,scenarios));
        Mockito.verify(parallel,times(2));


    }
}
