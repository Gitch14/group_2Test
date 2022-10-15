package executor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.ProxyConfigHolder;
import executor.model.ProxyCredentials;
import executor.model.ProxyNetworkConfig;
import executor.service.ProxySourcesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProxySourcesClientService implements ProxySourcesClient
{
    
    private ObjectMapper objectMapper;
    
    @Autowired
    public ProxySourcesClientService(ObjectMapper objectMapper)
    {
        this.objectMapper = objectMapper;
    }
    
    public ProxySourcesClientService()
    {
    
    }
    
    @Override
    public ProxyConfigHolder getProxy()
    {
        List<ProxyCredentials> credentials = new ArrayList<>();
        List<ProxyNetworkConfig> network = new ArrayList<>();
        
        try (InputStream proxyCredentialsInputStream = getClass().getResourceAsStream("/ProxyCredentials.json");
             InputStream proxyNetworkInputStream = getClass().getResourceAsStream("/ProxyNetwork.json");
             BufferedReader proxyCredentialsReader = new BufferedReader(new InputStreamReader(proxyCredentialsInputStream));
             BufferedReader proxyNetworkReader = new BufferedReader(new InputStreamReader(proxyNetworkInputStream)))
        {
            credentials.addAll(List.of(objectMapper.readValue(proxyCredentialsReader, ProxyCredentials[].class)));
            network.addAll(List.of(objectMapper.readValue(proxyNetworkReader, ProxyNetworkConfig[].class)));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
        Random random = new Random();
        int randomNetwork = random.nextInt(network.size());
        int randomCredential = random.nextInt(credentials.size());
        
        return new ProxyConfigHolder(network.get(randomNetwork), credentials.get(randomCredential));
    }
}
