package executor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.Scenario;
import executor.service.ScenarioSourceListener;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ScenarioSourceListenerService implements ScenarioSourceListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Queue<Scenario> scenarios;

    @Override
    public void execute() {
        scenarios = new ConcurrentLinkedQueue();
        try {
            URL resource = this.getClass().getClassLoader().getResource("scenarios.json");

            if (resource != null) {
                File file = new File(resource.toURI());
                scenarios.addAll(List.of(objectMapper.readValue(file, Scenario[].class)));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public Queue<Scenario> getScenarios() {
        execute();
        return scenarios;
    }
}
