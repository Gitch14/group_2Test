package executor.service.impl;

import executor.model.Scenario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScenarioSourceListenerServiceTest {

    private final ScenarioSourceListenerService scenarioSourceListener = new ScenarioSourceListenerService();
    private List<Scenario> scenarios;

    @BeforeEach
    void setUp() {
        scenarioSourceListener.execute();
        scenarios = scenarioSourceListener.getScenarios();
    }

    @Test
    void execute() {
        assertEquals(scenarios.get(1).getName(), "test scenario 2", "JSON mapper works incorrectly");
    }
}
