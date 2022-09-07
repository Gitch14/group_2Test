package executor.service.impl;

import executor.model.Scenario;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScenarioSourceListenerServiceTest {

    private final ScenarioSourceListenerService scenarioSourceListener = new ScenarioSourceListenerService();

    @Test
    void execute() {
        Queue<Scenario> scenarios = scenarioSourceListener.execute();
        scenarios.poll(); // to remove first element for testing second element
        assertEquals(scenarios.poll().getName(), "test scenario 2", "JSON mapper works incorrectly");
    }
}
