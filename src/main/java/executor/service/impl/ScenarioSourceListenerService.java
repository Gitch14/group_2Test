package executor.service.impl;

import executor.model.Scenario;
import executor.service.ScenarioSourceListener;
import executor.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ScenarioSourceListenerService implements ScenarioSourceListener
{
    
    private ObjectMapperUtil objectMapperUtil;
    
    @Autowired
    public ScenarioSourceListenerService(ObjectMapperUtil objectMapperUtil)
    {
        this.objectMapperUtil = objectMapperUtil;
    }
    
    public ScenarioSourceListenerService()
    {
    
    }
    
    @Override
    public Queue<Scenario> execute()
    {
        Queue<Scenario> scenarios = new ConcurrentLinkedQueue<>();
        
        try (InputStream in = getClass().getResourceAsStream("/scenarios.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            scenarios.addAll(List.of(objectMapperUtil.getObjectMapper().readValue(reader, Scenario[].class)));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
        
        return scenarios;
    }
}
