package executor.facade.impl;

import executor.model.ProxyConfigHolder;
import executor.model.Scenario;
import executor.model.Step;
import executor.service.impl.ProxySourcesClientService;
import executor.service.impl.ScenarioSourceListenerService;
import executor.util.ObjectMapperUtil;

import java.util.Objects;
import java.util.Queue;

public class Worker implements Runnable{

    private ScenarioSourceListenerService scenarioSourceListenerService;
    private Queue<Scenario> scenarios;

    public Worker(ScenarioSourceListenerService scenarioSourceListenerService, Queue<Scenario> scenarios) {
        this.scenarioSourceListenerService = scenarioSourceListenerService;
        this.scenarios = scenarios;
    }

  /*
    private ProxyConfigHolder proxyConfigHolder;
    private Step step;

    public Worker(ProxyConfigHolder proxyConfigHolder, Step step) {
        this.proxyConfigHolder = proxyConfigHolder;
        this.step = step;
    }

 */

    @Override
    public void run() {
        Queue<Scenario> scenarios = scenarioSourceListenerService.execute();
        for (int i = 0; i < scenarios.size()+1; i++) {
            // System.out.println(proxySourcesClientService.getProxy());
            System.out.println(scenarios.poll().getName());
            System.out.println(scenarios.size());
        }
        /*
        System.out.println(proxyConfigHolder.getProxyNetworkConfig().getHostname());
        System.out.println(proxyConfigHolder.getProxyNetworkConfig().getPort());
        System.out.println(proxyConfigHolder.getProxyCredentials().getUsername());
        System.out.println(proxyConfigHolder.getProxyCredentials().getPassword());
        System.out.println(step.getAction());
        System.out.println(step.getValue());

         */
    }



}
