package executor.facade.impl;

import executor.model.*;
import executor.service.impl.ProxySourcesClientService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.util.ObjectMapperUtil;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
/*
        ParallelFlowExecuteService parallelFlowExecuteService = new ParallelFlowExecuteService();
        parallelFlowExecuteService.parallelExecute(new Worker());

 */
      //  ProxyConfigHolder proxyConfigHolder = new ProxyConfigHolder(new ProxyNetworkConfig("Host1",8081),new ProxyCredentials("user1","pass1"));
      //  Step step = new Step("Sleep","Sleep");

        ProxySourcesClientService proxySourcesClientService = new ProxySourcesClientService();
      //  proxySourcesClientService.getProxy();

        ScenarioSourceListenerService scenarioSourceListenerService = new ScenarioSourceListenerService(new ObjectMapperUtil());
       // scenarioSourceListenerService.execute();

        Queue<Scenario> scenarios = scenarioSourceListenerService.execute();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(new Worker(scenarioSourceListenerService,scenarios));
        threadPoolExecutor.shutdown();

       // Queue<Scenario> queue = scenarioSourceListenerService.execute();
      //  queue.poll();

       // System.out.println(queue.poll().getName());
    }
}
