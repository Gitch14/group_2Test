package executor.service.impl;

import executor.model.Scenario;
import executor.service.ScenarioSourceListener;
import executor.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ScenarioSourceListenerService implements ScenarioSourceListener {

    private ObjectMapperUtil objectMapperUtil;

    @Autowired
    public ScenarioSourceListenerService(ObjectMapperUtil objectMapperUtil) {
        this.objectMapperUtil = objectMapperUtil;
    }

    public ScenarioSourceListenerService() {

    }

    @Override
    public Queue<Scenario> execute() {
        Queue<Scenario> scenarios = new ConcurrentLinkedQueue<>();
        try {
            URL resource = this.getClass().getClassLoader().getResource("scenarios.json");

            if (resource != null) {
                File file = new File(resource.toURI());
                scenarios.addAll(List.of(objectMapperUtil.getObjectMapper().readValue(file, Scenario[].class)));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return scenarios;
    }
}
