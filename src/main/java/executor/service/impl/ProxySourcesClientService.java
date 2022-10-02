package executor.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.model.ProxyConfigHolder;
import executor.model.ProxyCredentials;
import executor.model.ProxyNetworkConfig;
import executor.service.ProxySourcesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProxySourcesClientService implements ProxySourcesClient {

    private ObjectMapper objectMapper;

    @Autowired
    public ProxySourcesClientService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ProxySourcesClientService() {

    }

    @Override
    public ProxyConfigHolder getProxy() {
        List<ProxyCredentials> credentials = new ArrayList<>();
        List<ProxyNetworkConfig> network = new ArrayList<>();
        try {
            URL credentialURI = this.getClass().getClassLoader().getResource("ProxyCredentials.json");
            URL networkURI = this.getClass().getClassLoader().getResource("ProxyNetwork.json");

            if (credentialURI != null && networkURI != null) {
                File file = new File(credentialURI.toURI());
                credentials.addAll(List.of(objectMapper.readValue(file, ProxyCredentials[].class)));
                file = new File(networkURI.toURI());
                network.addAll(List.of(objectMapper.readValue(file, ProxyNetworkConfig[].class)));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int randomNetwork = random.nextInt(network.size());
        int randomCredential = random.nextInt(credentials.size());

        return new ProxyConfigHolder(network.get(randomNetwork), credentials.get(randomCredential));
    }
}
