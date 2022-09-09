package executor.service;

import executor.model.Scenario;

import java.util.Queue;

public interface ScenarioSourceListener {
    Queue<Scenario> execute();
}
