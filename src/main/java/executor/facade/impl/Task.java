package executor.facade.impl;

import executor.model.Scenario;
import executor.service.impl.ProxySourcesClientService;
import executor.service.impl.ScenarioSourceListenerService;

import java.util.Queue;

public class Task implements Runnable{

    private ScenarioSourceListenerService scenarioSourceListenerService;
    private ProxySourcesClientService proxySourcesClientService;
    private Queue<Scenario> scenarios;

    public Task(ScenarioSourceListenerService scenarioSourceListenerService, ProxySourcesClientService proxySourcesClientService, Queue<Scenario> scenarios) {
        this.scenarioSourceListenerService = scenarioSourceListenerService;
        this.proxySourcesClientService = proxySourcesClientService;
        this.scenarios = scenarios;
    }


    @Override
    public void run() {

            Queue<Scenario> scenarios = scenarioSourceListenerService.execute();
            for (int i = 0; i < scenarios.size()+1; i++) {
                scenarios.peek().getName();
                scenarios.peek().getSite();
                scenarios.poll();
            }

            for (int i = 0; i < scenarios.size()+1; i++) {
                proxySourcesClientService.getProxy().getProxyCredentials();
                proxySourcesClientService.getProxy().getProxyNetworkConfig();
            }

        }

    @Override
    public String toString() {
        return "Task{" +
                "scenarioSourceListenerService=" + scenarioSourceListenerService +
                ", proxySourcesClientService=" + proxySourcesClientService +
                ", scenarios=" + scenarios +
                '}';
    }
}
