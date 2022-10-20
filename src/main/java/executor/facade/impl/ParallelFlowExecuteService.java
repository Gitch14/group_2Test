package executor.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.facade.ParallelFlowExecute;
import executor.model.Scenario;
import executor.service.impl.ProxySourcesClientService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class ParallelFlowExecuteService implements ParallelFlowExecute {

    @Value("${ThreadPoolConfig.corePoolSize}")
    private Integer corePoolSize;

    @Value("${ThreadPoolConfig.keepAliveTime}")
    private Integer keepAliveTime;

    public ParallelFlowExecuteService() {

    }
    ProxySourcesClientService proxySourcesClientService = new ProxySourcesClientService(new ObjectMapper());
    ScenarioSourceListenerService scenarioSourceListenerService = new ScenarioSourceListenerService(new ObjectMapperUtil());
    Queue<Scenario> scenarios = scenarioSourceListenerService.execute();

    public void parallelExecute(Runnable task) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,
                20, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(new Task(scenarioSourceListenerService,proxySourcesClientService,scenarios));
        threadPoolExecutor.shutdown();
    }
}