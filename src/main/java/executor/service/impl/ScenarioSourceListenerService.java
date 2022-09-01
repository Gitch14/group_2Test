package executor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.Scenario;
import executor.service.ScenarioSourceListener;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScenarioSourceListenerService implements ScenarioSourceListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<Scenario> scenarios;

    @Override
    public void execute() {
        try {
            scenarios = new ArrayList<>();
            URL resource = this.getClass().getClassLoader().getResource("scenarios.json");

            if (resource == null)
                return;

            File file = new File(resource.toURI());
            scenarios = List.of(objectMapper.readValue(file, Scenario[].class));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }
}
